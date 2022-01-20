package clark.corba;

/**
 * Generated from IDL interface "MonitorStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public final class MonitorStationHolder	implements org.omg.CORBA.portable.Streamable{
	 public MonitorStation value;
	public MonitorStationHolder()
	{
	}
	public MonitorStationHolder (final MonitorStation initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return MonitorStationHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = MonitorStationHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		MonitorStationHelper.write (_out,value);
	}
}
