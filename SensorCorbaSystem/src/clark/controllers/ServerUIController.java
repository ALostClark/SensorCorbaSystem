package clark.controllers;

import clark.RunCentralServer;
import clark.Tools.UiTools;
import clark.corba.Entry;
import clark.corba.MonitorStation;
import clark.orbs.LocalStationOrb;
import clark.orbs.MonitorStationOrb;
import clark.portable.CentralServer;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static clark.RunCentralServer.centralServer;

public class ServerUIController {

    @FXML
    public TableView<Entry> fxTableView;
    private ObservableList<Entry> entries;
    @FXML
    public BorderPane fxMainBorderPane;
    @FXML
    public ListView<clark.Tools.Alert> fxAlertList;
    public ObservableList<clark.Tools.Alert> alerts;
    public TextArea textAreaEmpty;
    @FXML
    public TreeView<String> fxTreeView;

    @FXML
    public void initialize() throws IOException {
        CentralServer.serverUIController = this;
        RunCentralServer.setControlScreenController(this);
        entries = FXCollections.observableList(new ArrayList<>());
        fxTableView.setItems(entries);
        alerts = FXCollections.observableList(new ArrayList<>());
        fxAlertList.setItems(alerts);

        update();
    }


    public void update(){
        LocalStationOrb stationOrb = new LocalStationOrb(UiTools.getStartArgs());
        for (String station : centralServer.getStationList()) {
            try {
                for (Entry entry : stationOrb.getObjectAtReference(station).get_logs()) {
                    System.out.println(entry.location + ": " + entry.value + " ("
                            + new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(new Date(entry.timestamp)) + ")");
                }
            } catch (CannotProceed | InvalidName | NotFound cannotProceed) {
                cannotProceed.printStackTrace();
            }
        }
    }

    public void addAlert(clark.Tools.Alert alert) {
        alerts.add(alert);
        fxAlertList.refresh();
    }

    public void updateServerTree(Map<String, String[]> stationsByServer) {
        TreeItem<String> rootNode = new TreeItem<>("Servers");
        rootNode.setExpanded(true);
        for (String server : stationsByServer.keySet()) {
            TreeItem<String> item = new TreeItem<>(server);
            item.getChildren().addAll(stringToTreeItem(stationsByServer.get(server)));
            rootNode.getChildren().add(item);
        }
        fxTreeView.setRoot(rootNode);
    }

    private List<TreeItem<String>> stringToTreeItem(String[] strings) {
        List<TreeItem<String>> items = new ArrayList<>();
        for (String string : strings) {
            TreeItem<String> item = new TreeItem<>(string);
            items.add(item);
        }
        return items;
    }

    @FXML
    public void onTreeClick() {
        TreeItem<String> selectedItem = fxTreeView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            entries.clear();
            TreeItem<String> localServerItem = selectedItem.getParent();
            if (localServerItem != null && localServerItem.getParent() != null) {
                entries.addAll(extractLogsForSensor(CentralServer.instance.getStationLogs(localServerItem.getValue()), selectedItem.getValue()));
                generateTableView();
            } else {
                if (localServerItem != null) {
                    entries.addAll(CentralServer.instance.getStationLogs(selectedItem.getValue()));
                    generateTableView();

                    TableColumn<Entry, String> stationColumn = new TableColumn<>("Monitor Station");
                    stationColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().location));
                    fxTableView.getColumns().add(stationColumn);
                }
            }
        }
    }

    @FXML
    public void disableNode() {
        TreeItem<String> selectedItem = fxTreeView.getSelectionModel().getSelectedItem();
        if (selectedItem != null && selectedItem.getParent() != null && selectedItem.getParent().getParent() != null) {
            MonitorStationOrb orb = new MonitorStationOrb(UiTools.getStartArgs());
            try {
                MonitorStation station = orb.getObjectAtReference(selectedItem.getValue());
                station.set_status(!station.get_status());
            } catch (CannotProceed | InvalidName | NotFound cannotProceed) {
                cannotProceed.printStackTrace();
            }
        }
    }

    private void generateTableView() {
        fxTableView.getColumns().clear();

        TableColumn<Entry, String> timestampColumn = new TableColumn<>("Timestamp");
        timestampColumn.setCellValueFactory(cellData -> convertTimestampToView(cellData.getValue().timestamp));
        fxTableView.getColumns().add(timestampColumn);

        TableColumn<Entry, String> readingColumn = new TableColumn<>("NOX Value");
        readingColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().value)));
        fxTableView.getColumns().add(readingColumn);
    }

    private List<Entry> extractLogsForSensor(Entry[] entries, String sensor) {
        List<Entry> entriesBySensor = new ArrayList<>();
        for (Entry entry : entries) {
            if (entry.location.equals(sensor)) { entriesBySensor.add(entry); }
        }
        return entriesBySensor;
    }

    private ReadOnlyStringWrapper convertTimestampToView(long timeStamp) {
        return new ReadOnlyStringWrapper(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(timeStamp)));
    }

}
