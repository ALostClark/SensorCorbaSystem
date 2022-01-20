package clark.corba;

/**
 * Generated from IDL interface "CentralServer".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public final class CentralServerHolder	implements org.omg.CORBA.portable.Streamable{
	 public CentralServer value;
	public CentralServerHolder()
	{
	}
	public CentralServerHolder (final CentralServer initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return CentralServerHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = CentralServerHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		CentralServerHelper.write (_out,value);
	}
}
