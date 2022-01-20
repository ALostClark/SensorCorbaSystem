package clark;

import clark.controllers.MonitorStationUI;
import clark.orbs.LocalStationOrb;
import clark.orbs.MonitorStationOrb;
import clark.portable.MonitorStation;
import javafx.application.Application;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class RunMonitorStation extends Thread {

    public static MonitorStation station;

    private static String[] staticArgs;
    public static String location;
    public static String localServer;

    public static class MainClass {
        public static void main(String[] args) {

            staticArgs = args;
            Application.launch(MonitorStationUI.MyAppStartClass.class, staticArgs);
        }
    }

    @Override
    public void run() {
        super.run();

        LocalStationOrb serverOrb = new LocalStationOrb(staticArgs);
        MonitorStationOrb orb = new MonitorStationOrb(staticArgs);

        try {

            System.out.println("reached");
            orb.bindObjectToName(location, station);
            serverOrb.getObjectAtReference(localServer).register(location);

            Runtime.getRuntime().addShutdownHook(new RunMonitorStation.ShutdownHook(location, localServer, serverOrb));

        } catch (WrongPolicy | ServantNotActive | CannotProceed | NotFound | InvalidName wrongPolicy) {
            wrongPolicy.printStackTrace();
        }
        orb.runServer();
    }

    private static class ShutdownHook extends Thread {
        private final String location;
        private final String server;
        private final LocalStationOrb orb;

        public ShutdownHook(String location, String server, LocalStationOrb orb) {
            this.location = location;
            this.server = server;
            this.orb = orb;
        }

        @Override
        public void run() {
            super.run();

            try {
                orb.getObjectAtReference(server).unregister(location);
            } catch (CannotProceed | InvalidName | NotFound cannotProceed) {
                cannotProceed.printStackTrace();
            }
        }
    }
    

}

