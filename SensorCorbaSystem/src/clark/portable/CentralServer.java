package clark.portable;

import clark.RunCentralServer;
import clark.Tools.Alert;
import clark.Tools.UiTools;
import clark.controllers.ServerUIController;
import clark.corba.CentralServerPOA;
import clark.corba.Entry;
import clark.corba.InactiveStationException;
import clark.corba.LocalControlStation;
import clark.orbs.LocalStationOrb;
import clark.orbs.MonitorStationOrb;
import javafx.application.Platform;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.*;

public class CentralServer extends CentralServerPOA {

    private LocalStationOrb stationOrb;
    private List<String> stationList;
    public static ServerUIController serverUIController;
    public static CentralServer instance;

    private List<Alert> alertList;
    private String location;

    public List<String> getStationList() {return stationList;}

    public CentralServer(LocalStationOrb stationOrb, String location){
        instance = this;
        this.stationOrb = stationOrb;
        stationList = new ArrayList<>();
        this.location = location;

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //pullLogs();
                updateUI();
            }
        }, 1000, 1000 * 30);
    }

    @Override
    public void register(String location) {
        stationList.add(location);
        //if (serverUIController != null){
            updateUI();
       // }
    }

    @Override
    public void unregister(String location) {
        stationList.remove(location);
        //if (serverUIController != null) {
            updateUI();
       // }
    }

    @Override
    public void raise_alarm( String monitor_station) {
        try {
            Alert alert = new Alert(monitor_station, new MonitorStationOrb(UiTools.getStartArgs()).getObjectAtReference(monitor_station).get_value(), System.currentTimeMillis());
            serverUIController.addAlert(alert);
        } catch (InactiveStationException | CannotProceed | InvalidName | NotFound e) {
            e.printStackTrace();
        }
        updateUI();
    }

    @Override
    public String get_location() {
        return this.location;
    }

    private void pullLogs() {
        for (String server : stationList) {
            LocalStationOrb orb = new LocalStationOrb(RunCentralServer.getStartArgs());
            try {
                LocalControlStation station = orb.getObjectAtReference(server);
                station.get_logs();

                for (Entry entry: station.get_logs()) {

                }

            } catch (CannotProceed | InvalidName | NotFound cannotProceed) {
                cannotProceed.printStackTrace();
            }
        }
    }

    public Entry[] getStationLogs(String station) {
        LocalStationOrb orb = new LocalStationOrb(RunCentralServer.getStartArgs());
        try {
            return orb.getObjectAtReference(station).get_logs();
        } catch (CannotProceed | InvalidName | NotFound cannotProceed) {
            cannotProceed.printStackTrace();
        }
        return new Entry[0];
    }

    private void updateUI(){
        Map<String, String[]> servers = new LinkedHashMap<>();
        for (String server : stationList) {
            try {
                servers.put(server, stationOrb.getObjectAtReference(server).get_stations());
            } catch (CannotProceed | InvalidName | NotFound cannotProceed) {
                cannotProceed.printStackTrace();
            }
        }
        Platform.runLater(() -> serverUIController.updateServerTree(servers));
    }

}
