package clark.corba;

/**
 * Generated from IDL interface "LocalControlStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public final class LocalControlStationHolder	implements org.omg.CORBA.portable.Streamable{
	 public LocalControlStation value;
	public LocalControlStationHolder()
	{
	}
	public LocalControlStationHolder (final LocalControlStation initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return LocalControlStationHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = LocalControlStationHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		LocalControlStationHelper.write (_out,value);
	}
}
