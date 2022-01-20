package clark.corba;


/**
 * Generated from IDL exception "InactiveStationException".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public abstract class InactiveStationExceptionHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(InactiveStationExceptionHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_exception_tc(clark.corba.InactiveStationExceptionHelper.id(),"InactiveStationException",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("reason", org.omg.CORBA.ORB.init().create_string_tc(0), null)});
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final clark.corba.InactiveStationException s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static clark.corba.InactiveStationException extract (final org.omg.CORBA.Any any)
	{
		org.omg.CORBA.portable.InputStream in = any.create_input_stream();
		try
		{
			return read (in);
		}
		finally
		{
			try
			{
				in.close();
			}
			catch (java.io.IOException e)
			{
			throw new RuntimeException("Unexpected exception " + e.toString() );
			}
		}
	}

	public static String id()
	{
		return "IDL:clark/corba/InactiveStationException:1.0";
	}
	public static clark.corba.InactiveStationException read (final org.omg.CORBA.portable.InputStream in)
	{
		String id = in.read_string();
		if (!id.equals(id())) throw new org.omg.CORBA.MARSHAL("wrong id: " + id);
		java.lang.String x0;
		x0=in.read_string();
		final clark.corba.InactiveStationException result = new clark.corba.InactiveStationException(id, x0);
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final clark.corba.InactiveStationException s)
	{
		out.write_string(id());
		java.lang.String tmpResult1 = s.reason;
out.write_string( tmpResult1 );
	}
}
