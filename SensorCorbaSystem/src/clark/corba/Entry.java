package clark.corba;

/**
 * Generated from IDL struct "Entry".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public final class Entry
	implements org.omg.CORBA.portable.IDLEntity
{
	/** Serial version UID. */
	private static final long serialVersionUID = 1L;
	public Entry(){}
	public long timestamp;
	public java.lang.String location = "";
	public double value;
	public Entry(long timestamp, java.lang.String location, double value)
	{
		this.timestamp = timestamp;
		this.location = location;
		this.value = value;
	}
}
