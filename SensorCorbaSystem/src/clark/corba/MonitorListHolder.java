package clark.corba;

/**
 * Generated from IDL alias "MonitorList".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public final class MonitorListHolder
	implements org.omg.CORBA.portable.Streamable
{
	public java.lang.String[] value;

	public MonitorListHolder ()
	{
	}
	public MonitorListHolder (final java.lang.String[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return MonitorListHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = MonitorListHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		MonitorListHelper.write (out,value);
	}
}
