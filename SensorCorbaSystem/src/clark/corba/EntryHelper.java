package clark.corba;


/**
 * Generated from IDL struct "Entry".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public abstract class EntryHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(EntryHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_struct_tc(clark.corba.EntryHelper.id(),"Entry",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("timestamp", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(23)), null),new org.omg.CORBA.StructMember("location", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("value", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(7)), null)});
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final clark.corba.Entry s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static clark.corba.Entry extract (final org.omg.CORBA.Any any)
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
		return "IDL:clark/corba/Entry:1.0";
	}
	public static clark.corba.Entry read (final org.omg.CORBA.portable.InputStream in)
	{
		clark.corba.Entry result = new clark.corba.Entry();
		result.timestamp=in.read_longlong();
		result.location=in.read_string();
		result.value=in.read_double();
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final clark.corba.Entry s)
	{
		out.write_longlong(s.timestamp);
		java.lang.String tmpResult0 = s.location;
out.write_string( tmpResult0 );
		out.write_double(s.value);
	}
}
