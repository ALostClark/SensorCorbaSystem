package clark.controllers;

import clark.RunMonitorStation;
import clark.corba.InactiveStationException;
import clark.portable.MonitorStation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.text.DecimalFormat;

import static clark.RunMonitorStation.*;

public class MonitorStationUI {

    public static DecimalFormat formatTwoDecimal = new DecimalFormat("##.00");

    // DO NOT RUN!! run RunMonitorStation
    public static class MyAppStartClass extends Application {

        @Override
        public void start(Stage mainStage) {

            TextInputDialog dialogSensorName = new TextInputDialog();
            dialogSensorName.setTitle("Sensor name");
            dialogSensorName.setHeaderText("Enter Sensor Name");
            dialogSensorName.showAndWait();

            TextInputDialog dialogSensorLocation = new TextInputDialog();
            dialogSensorLocation.setTitle("Sensor Location");
            dialogSensorLocation.setHeaderText("Enter Sensor Location");
            dialogSensorLocation.showAndWait();

            if (!dialogSensorName.getEditor().getText().equals("")){
                location = dialogSensorName.getEditor().getText();
            }else{
                System.out.println("invalid location");
            }

            if (!dialogSensorLocation.getEditor().getText().equals("")){
                localServer = dialogSensorLocation.getEditor().getText();
            }else{
                System.out.println("invalid server name");
            }

            station = new MonitorStation(location);
            Thread thread = new RunMonitorStation();
            thread.start();

            mainStage.setWidth(500);
            mainStage.setHeight(200);

            Label labelTitle = new Label("Select amount");
            Label labelShowResult = new Label(" ");

            labelShowResult.setTextFill(Color.BLACK);

            Slider sliderSensor = new Slider();

            sliderSensor.setMin(0);
            sliderSensor.setMax(500);
            sliderSensor.setValue(0);
            sliderSensor.setShowTickLabels(true);
            sliderSensor.setShowTickMarks(true);

            sliderSensor.setBlockIncrement(10);

            // Adding Listener to value property.
            sliderSensor.valueProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    labelShowResult.setText("Value: " + Double.parseDouble(formatTwoDecimal.format(newValue)));
                    station.setValue(Double.parseDouble(formatTwoDecimal.format(newValue)));

                } catch (InactiveStationException e) {e.printStackTrace();}
            });

            VBox vBox = new VBox();

            vBox.setPadding(new Insets(20));
            vBox.setSpacing(10);
            vBox.getChildren().addAll(labelTitle, sliderSensor, labelShowResult);

            // create Scene and add to the frame
            Scene scene = new Scene(vBox, 350, 200);
            mainStage.setScene(scene);
            mainStage.setTitle("Sensor Name: " + location);
            mainStage.show();

        }
    }
}
