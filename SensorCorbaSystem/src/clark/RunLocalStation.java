package clark;

import clark.Tools.UiTools;
import clark.orbs.CentralServerOrb;
import clark.orbs.LocalStationOrb;
import clark.orbs.MonitorStationOrb;
import clark.portable.LocalControlStation;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import javax.swing.*;

public class RunLocalStation extends Thread {

    private static LocalStationOrb stationOrb;
    private static LocalControlStation station;
    private static String location;

    public static void main(String[] args) throws WrongPolicy, InvalidName, ServantNotActive, CannotProceed, NotFound {
        UiTools.setStartArgs(args);
        location = JOptionPane.showInputDialog(null, "Enter the location of the station", "Location", JOptionPane.QUESTION_MESSAGE);
        String server = JOptionPane.showInputDialog(null, "Enter the location of the server", "Server", JOptionPane.QUESTION_MESSAGE);

        MonitorStationOrb monitorOrb = new MonitorStationOrb(args);
        stationOrb = new LocalStationOrb(args);
        CentralServerOrb centralServerOrb = new CentralServerOrb(args);
        station = new LocalControlStation(monitorOrb, location, server,location + ".csv");
        new RunLocalStation().start();

        centralServerOrb.getObjectAtReference(server).register(location);
    }

    @Override
    public void run() {
        super.run();
        try {
            stationOrb.bindObjectToName(location, station);
            stationOrb.runServer();
        } catch (ServantNotActive | WrongPolicy | CannotProceed | InvalidName | NotFound servantNotActive) {
            servantNotActive.printStackTrace();
        }

    }
}
