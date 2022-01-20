package clark.Tools;

import java.text.SimpleDateFormat;

public class Alert {

    public String location;
    public double reading;
    public long timeStamp;
    public String alertLevel;

    public String pattern = "dd-MM-yyyy HH:mm:ss";
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    public Alert(String location, double reading, long timeStamp){

        this.location = location;
        this.reading = reading;
        this.timeStamp = timeStamp;

        alertLevelCheck();
    }

    public void alertLevelCheck(){

        if (reading < 50){
            alertLevel = "Good";
        }else if (reading >= 51  && reading < 100 ){
            alertLevel = "Moderate";
        }else if (reading >= 101  && reading < 150 ){
            alertLevel = "Unhealthy for Sensitive Groups";
        }else if (reading >= 151  && reading < 200 ){
            alertLevel = "Unhealthy";
        }else if (reading >= 201  && reading < 300 ){
            alertLevel = "Very Unhealthy";
        }else if (reading >= 300){
            alertLevel = "Extremely Unhealthy";
        }

    }

    @Override
    public String toString() {
        return  "location: " + location +  ", reading: " + reading + ", alertLevel: " + alertLevel;
    }
}
