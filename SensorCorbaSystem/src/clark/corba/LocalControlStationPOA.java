package clark.corba;


/**
 * Generated from IDL interface "LocalControlStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public abstract class LocalControlStationPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, clark.corba.LocalControlStationOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "get_stations", Integer.valueOf(0));
		m_opsHash.put ( "get_logs", Integer.valueOf(1));
		m_opsHash.put ( "register", Integer.valueOf(2));
		m_opsHash.put ( "report_value", Integer.valueOf(3));
		m_opsHash.put ( "get_location", Integer.valueOf(4));
		m_opsHash.put ( "unregister", Integer.valueOf(5));
	}
	private String[] ids = {"IDL:clark/corba/LocalControlStation:1.0"};
	public clark.corba.LocalControlStation _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		clark.corba.LocalControlStation __r = clark.corba.LocalControlStationHelper.narrow(__o);
		return __r;
	}
	public clark.corba.LocalControlStation _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		clark.corba.LocalControlStation __r = clark.corba.LocalControlStationHelper.narrow(__o);
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
			case 0: // get_stations
			{
				_out = handler.createReply();
				clark.corba.MonitorListHelper.write(_out,get_stations());
				break;
			}
			case 1: // get_logs
			{
				_out = handler.createReply();
				clark.corba.EntryListHelper.write(_out,get_logs());
				break;
			}
			case 2: // register
			{
				java.lang.String _arg0=_input.read_string();
				_out = handler.createReply();
				register(_arg0);
				break;
			}
			case 3: // report_value
			{
				java.lang.String _arg0=_input.read_string();
				double _arg1=_input.read_double();
				_out = handler.createReply();
				report_value(_arg0,_arg1);
				break;
			}
			case 4: // get_location
			{
				_out = handler.createReply();
				java.lang.String tmpResult7 = get_location();
_out.write_string( tmpResult7 );
				break;
			}
			case 5: // unregister
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
