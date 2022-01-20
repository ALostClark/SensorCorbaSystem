package clark.corba;

/**
 * Generated from IDL alias "EntryList".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public final class EntryListHolder
	implements org.omg.CORBA.portable.Streamable
{
	public clark.corba.Entry[] value;

	public EntryListHolder ()
	{
	}
	public EntryListHolder (final clark.corba.Entry[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return EntryListHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = EntryListHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		EntryListHelper.write (out,value);
	}
}
