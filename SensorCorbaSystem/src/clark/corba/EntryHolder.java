package clark.corba;

/**
 * Generated from IDL struct "Entry".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public final class EntryHolder
	implements org.omg.CORBA.portable.Streamable
{
	public clark.corba.Entry value;

	public EntryHolder ()
	{
	}
	public EntryHolder(final clark.corba.Entry initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return clark.corba.EntryHelper.type ();
	}
	public void _read(final org.omg.CORBA.portable.InputStream _in)
	{
		value = clark.corba.EntryHelper.read(_in);
	}
	public void _write(final org.omg.CORBA.portable.OutputStream _out)
	{
		clark.corba.EntryHelper.write(_out, value);
	}
}
