package clark.portable;

import clark.Tools.UiTools;
import clark.corba.Entry;
import clark.corba.InactiveStationException;
import clark.corba.LocalControlStationPOA;
import clark.corba.MonitorStation;
import clark.orbs.CentralServerOrb;
import clark.orbs.MonitorStationOrb;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class LocalControlStation extends LocalControlStationPOA {

    private final CentralServerOrb centralOrb;
    private final String mainServer;
    private MonitorStationOrb orb;
    private String location;
    private List<String> sensors;
    private File logFile;

    public LocalControlStation(MonitorStationOrb orb, String location, String mainServer, String filename) {
        this.orb = orb;
        this.centralOrb = new CentralServerOrb(UiTools.getStartArgs());
        this.mainServer = mainServer;
        this.location = location;
        this.sensors = new ArrayList<>();
        this.logFile = new File("logs/" + filename);
        checkDirs();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (String sensor : sensors) {
                    try {
                        MonitorStation station = orb.getObjectAtReference(sensor);
                        if (station.get_status()) {
                            report_value(sensor, station.get_value());
                        }
                    } catch (CannotProceed | InvalidName | NotFound | InactiveStationException cannotProceed) {
                        cannotProceed.printStackTrace();
                    }
                }
            }
        }, 1000, 1000 * 15);
    }

    @Override
    public void register(String location) {
        sensors.add(location);
    }

    @Override
    public void unregister(String location) {
        sensors.remove(location);
    }

    @Override
    public String get_location() {
        return location;
    }

    @Override
    public void report_value(String location, double value) {
        Entry entry = new Entry();
        // Set timestamp server time. Adds a few ms inaccuracy, but also means that stations don't need accurate clocks
        entry.timestamp = System.currentTimeMillis();
        entry.location = location;
        entry.value = value;

        try {
            serialize(entry);
        } catch (IOException e) { e.printStackTrace(); }

        if (value >= 50) {
            try {
                centralOrb.getObjectAtReference(mainServer).raise_alarm(location);
            } catch (CannotProceed | InvalidName | NotFound cannotProceed) {
                cannotProceed.printStackTrace();
            }
        }

    }

    private Entry[] deserialize() throws IOException {
        checkDirs();
        List<Entry> entries = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(logFile));
        String line = "";
        while ((line = reader.readLine()) != null) {
            String[] value = line.split(",");
            Entry entry = new Entry();
            entry.timestamp = Long.parseLong(value[0]);
            entry.location = value[1];
            entry.value = Double.parseDouble(value[2]);
            entries.add(entry);
        }
        reader.close();
        return entries.toArray(Entry[]::new);
    }

    private void serialize(Entry entry) throws IOException {
        checkDirs();
        BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
        writer.write(entry.timestamp + "," + entry.location + "," + entry.value + "\n");
        writer.close();
    }

    private void checkDirs() {
        if (!logFile.exists()) {
            new File("logs").mkdirs();
            try { this.logFile.createNewFile(); } catch (IOException e) { e.printStackTrace(); }
        }
    }

    @Override
    public Entry[] get_logs() {
        try {
            return deserialize();
        } catch (IOException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public String[] get_stations() {
        return sensors.toArray(String[]::new);
    }
}
