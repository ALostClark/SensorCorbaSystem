package clark.corba;

/**
 * Generated from IDL alias "EntryList".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public abstract class EntryListHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;

	public static void insert (org.omg.CORBA.Any any, clark.corba.Entry[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static clark.corba.Entry[] extract (final org.omg.CORBA.Any any)
	{
		if ( any.type().kind() == org.omg.CORBA.TCKind.tk_null)
		{
			throw new org.omg.CORBA.BAD_OPERATION ("Can't extract from Any with null type.");
		}
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(EntryListHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_alias_tc(clark.corba.EntryListHelper.id(), "EntryList",org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CORBA.ORB.init().create_struct_tc(clark.corba.EntryHelper.id(),"Entry",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("timestamp", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(23)), null),new org.omg.CORBA.StructMember("location", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("value", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(7)), null)})));
				}
			}
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:clark/corba/EntryList:1.0";
	}
	public static clark.corba.Entry[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		clark.corba.Entry[] _result;
		int _l_result0 = _in.read_long();
		try
		{
			 int x = _in.available();
			 if ( x > 0 && _l_result0 > x )
				{
					throw new org.omg.CORBA.MARSHAL("Sequence length too large. Only " + x + " available and trying to assign " + _l_result0);
				}
		}
		catch (java.io.IOException e)
		{
		}
		_result = new clark.corba.Entry[_l_result0];
		for (int i=0;i<_result.length;i++)
		{
			_result[i]=clark.corba.EntryHelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, clark.corba.Entry[] _s)
	{
		
		_out.write_long(_s.length);
		for (int i=0; i<_s.length;i++)
		{
			clark.corba.EntryHelper.write(_out,_s[i]);
		}

	}
}
