package clark.corba;


/**
 * Generated from IDL interface "MonitorStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public interface MonitorStationOperations
{
	/* constants */
	/* operations  */
	double get_value() throws clark.corba.InactiveStationException;
	java.lang.String get_location() throws clark.corba.InactiveStationException;
	boolean get_status();
	void set_status(boolean status);
}
