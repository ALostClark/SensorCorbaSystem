package clark.portable;

import clark.corba.InactiveStationException;
import clark.corba.MonitorStationPOA;

public class MonitorStation extends MonitorStationPOA {

    private boolean status;
    private String location;
    private double value;

    public MonitorStation(String location) {
        this.status = true;
        this.location = location;
        this.value = 0;
    }

    public void setValue(double value) throws InactiveStationException {
        if (!status){
            throw new InactiveStationException("Attempt to read value from inactive sensor");
        }
        this.value = value;
    }


    @Override
    public double get_value() throws InactiveStationException {
        if (!status){
            throw new InactiveStationException("Attempt to read value from inactive sensor");
        }
        return value;
    }

    @Override
    public String get_location() throws InactiveStationException {
        if (!status){
            throw new InactiveStationException("Attempt to read value from inactive sensor");
        }
        return location;
    }

    @Override
    public boolean get_status() {

        return status;
    }

    @Override
    public void set_status(boolean status) {
        this.status = status;
    }
}
