package clark.corba;


/**
 * Generated from IDL interface "CentralServer".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public abstract class CentralServerHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(CentralServerHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:clark/corba/CentralServer:1.0", "CentralServer");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final clark.corba.CentralServer s)
	{
			any.insert_Object(s);
	}
	public static clark.corba.CentralServer extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:clark/corba/CentralServer:1.0";
	}
	public static CentralServer read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(clark.corba._CentralServerStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final clark.corba.CentralServer s)
	{
		_out.write_Object(s);
	}
	public static clark.corba.CentralServer narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof clark.corba.CentralServer)
		{
			return (clark.corba.CentralServer)obj;
		}
		else if (obj._is_a("IDL:clark/corba/CentralServer:1.0"))
		{
			clark.corba._CentralServerStub stub;
			stub = new clark.corba._CentralServerStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static clark.corba.CentralServer unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof clark.corba.CentralServer)
		{
			return (clark.corba.CentralServer)obj;
		}
		else
		{
			clark.corba._CentralServerStub stub;
			stub = new clark.corba._CentralServerStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
