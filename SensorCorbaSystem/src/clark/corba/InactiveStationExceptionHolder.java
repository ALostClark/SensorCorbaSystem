package clark.corba;

/**
 * Generated from IDL exception "InactiveStationException".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public final class InactiveStationExceptionHolder
	implements org.omg.CORBA.portable.Streamable
{
	public clark.corba.InactiveStationException value;

	public InactiveStationExceptionHolder ()
	{
	}
	public InactiveStationExceptionHolder(final clark.corba.InactiveStationException initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return clark.corba.InactiveStationExceptionHelper.type ();
	}
	public void _read(final org.omg.CORBA.portable.InputStream _in)
	{
		value = clark.corba.InactiveStationExceptionHelper.read(_in);
	}
	public void _write(final org.omg.CORBA.portable.OutputStream _out)
	{
		clark.corba.InactiveStationExceptionHelper.write(_out, value);
	}
}
