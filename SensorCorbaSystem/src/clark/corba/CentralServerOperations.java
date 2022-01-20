package clark.corba;


/**
 * Generated from IDL interface "CentralServer".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public interface CentralServerOperations
{
	/* constants */
	/* operations  */
	void register(java.lang.String location);
	void unregister(java.lang.String location);
	void raise_alarm(java.lang.String control_station);
	java.lang.String get_location();
}
