package clark;

import clark.Tools.UiTools;
import clark.controllers.ServerUIController;
import clark.orbs.CentralServerOrb;
import clark.orbs.LocalStationOrb;
import clark.portable.CentralServer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import javax.swing.*;
import java.io.IOException;


public class RunCentralServer extends Application {

	public static ServerUIController serverUIController1;
	public static CentralServer centralServer;

	public static Scene scene;
	private static Stage stage;
	private static String[] startArgs;
	private static String location;

	public static void main(String[] args) {

		UiTools.setStartArgs(args);
		startArgs = args;

		location = JOptionPane.showInputDialog(null, "Enter the location of the station", "Location", JOptionPane.QUESTION_MESSAGE);

		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		LocalStationOrb stationOrb = new LocalStationOrb(UiTools.getStartArgs());
		centralServer = new CentralServer(stationOrb, location);
		new OrbThread(new CentralServerOrb(startArgs), centralServer, location).start();

		scene = new Scene(loadFXML("UI/sample.fxml"));

		RunCentralServer.stage = stage;
		stage.setScene(scene);
		stage.setTitle("Server");
		stage.show();


	}

	public static void setControlScreenController(ServerUIController serverUIController) {
		serverUIController1 = serverUIController;
	}

	public static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(RunCentralServer.class.getResource(fxml));
		return fxmlLoader.load();
	}

	public static String[] getStartArgs() {return startArgs;}

	public static Stage getStage() {
		return stage;
	}

	private static class OrbThread extends Thread {

		private final CentralServerOrb serverOrb;
		private final CentralServer centralServer;
		private final String location;

		public OrbThread(CentralServerOrb serverOrb, CentralServer centralServer, String location) {
			this.serverOrb = serverOrb;
			this.centralServer = centralServer;
			this.location = location;
		}

		@Override
		public void run() {
			super.run();

			try {
				serverOrb.bindObjectToName(location, centralServer);
				serverOrb.runServer();
			} catch (ServantNotActive | WrongPolicy | CannotProceed | InvalidName | NotFound servantNotActive) {
				servantNotActive.printStackTrace();
			}
		}
	}
}



