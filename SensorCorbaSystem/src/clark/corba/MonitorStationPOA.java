package clark.corba;


/**
 * Generated from IDL interface "MonitorStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public abstract class MonitorStationPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, clark.corba.MonitorStationOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "get_status", Integer.valueOf(0));
		m_opsHash.put ( "set_status", Integer.valueOf(1));
		m_opsHash.put ( "get_location", Integer.valueOf(2));
		m_opsHash.put ( "get_value", Integer.valueOf(3));
	}
	private String[] ids = {"IDL:clark/corba/MonitorStation:1.0"};
	public clark.corba.MonitorStation _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		clark.corba.MonitorStation __r = clark.corba.MonitorStationHelper.narrow(__o);
		return __r;
	}
	public clark.corba.MonitorStation _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		clark.corba.MonitorStation __r = clark.corba.MonitorStationHelper.narrow(__o);
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
			case 0: // get_status
			{
				_out = handler.createReply();
				_out.write_boolean(get_status());
				break;
			}
			case 1: // set_status
			{
				boolean _arg0=_input.read_boolean();
				_out = handler.createReply();
				set_status(_arg0);
				break;
			}
			case 2: // get_location
			{
			try
			{
				_out = handler.createReply();
				java.lang.String tmpResult2 = get_location();
_out.write_string( tmpResult2 );
			}
			catch(clark.corba.InactiveStationException _ex0)
			{
				_out = handler.createExceptionReply();
				clark.corba.InactiveStationExceptionHelper.write(_out, _ex0);
			}
				break;
			}
			case 3: // get_value
			{
			try
			{
				_out = handler.createReply();
				_out.write_double(get_value());
			}
			catch(clark.corba.InactiveStationException _ex0)
			{
				_out = handler.createExceptionReply();
				clark.corba.InactiveStationExceptionHelper.write(_out, _ex0);
			}
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
