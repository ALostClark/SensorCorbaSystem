package clark.corba;


/**
 * Generated from IDL interface "LocalControlStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public interface LocalControlStationOperations
{
	/* constants */
	/* operations  */
	void register(java.lang.String location);
	void unregister(java.lang.String location);
	java.lang.String get_location();
	void report_value(java.lang.String location, double value);
	clark.corba.Entry[] get_logs();
	java.lang.String[] get_stations();
}
