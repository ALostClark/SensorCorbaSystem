package clark.corba;


/**
 * Generated from IDL interface "CentralServer".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public abstract class CentralServerPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, clark.corba.CentralServerOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "register", Integer.valueOf(0));
		m_opsHash.put ( "get_location", Integer.valueOf(1));
		m_opsHash.put ( "raise_alarm", Integer.valueOf(2));
		m_opsHash.put ( "unregister", Integer.valueOf(3));
	}
	private String[] ids = {"IDL:clark/corba/CentralServer:1.0"};
	public clark.corba.CentralServer _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		clark.corba.CentralServer __r = clark.corba.CentralServerHelper.narrow(__o);
		return __r;
	}
	public clark.corba.CentralServer _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		clark.corba.CentralServer __r = clark.corba.CentralServerHelper.narrow(__o);
		return __r;
	}
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // register
			{
				java.lang.String _arg0=_input.read_string();
				_out = handler.createReply();
				register(_arg0);
				break;
			}
			case 1: // get_location
			{
				_out = handler.createReply();
				java.lang.String tmpResult11 = get_location();
_out.write_string( tmpResult11 );
				break;
			}
			case 2: // raise_alarm
			{
				java.lang.String _arg0=_input.read_string();
				_out = handler.createReply();
				raise_alarm(_arg0);
				break;
			}
			case 3: // unregister
			{
				java.lang.String _arg0=_input.read_string();
				_out = handler.createReply();
				unregister(_arg0);
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
