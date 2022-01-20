package clark.corba;


/**
 * Generated from IDL interface "LocalControlStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public abstract class LocalControlStationHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(LocalControlStationHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:clark/corba/LocalControlStation:1.0", "LocalControlStation");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final clark.corba.LocalControlStation s)
	{
			any.insert_Object(s);
	}
	public static clark.corba.LocalControlStation extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:clark/corba/LocalControlStation:1.0";
	}
	public static LocalControlStation read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(clark.corba._LocalControlStationStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final clark.corba.LocalControlStation s)
	{
		_out.write_Object(s);
	}
	public static clark.corba.LocalControlStation narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof clark.corba.LocalControlStation)
		{
			return (clark.corba.LocalControlStation)obj;
		}
		else if (obj._is_a("IDL:clark/corba/LocalControlStation:1.0"))
		{
			clark.corba._LocalControlStationStub stub;
			stub = new clark.corba._LocalControlStationStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static clark.corba.LocalControlStation unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof clark.corba.LocalControlStation)
		{
			return (clark.corba.LocalControlStation)obj;
		}
		else
		{
			clark.corba._LocalControlStationStub stub;
			stub = new clark.corba._LocalControlStationStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
