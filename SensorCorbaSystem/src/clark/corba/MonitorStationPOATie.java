package clark.corba;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "MonitorStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public class MonitorStationPOATie
	extends MonitorStationPOA
{
	private MonitorStationOperations _delegate;

	private POA _poa;
	public MonitorStationPOATie(MonitorStationOperations delegate)
	{
		_delegate = delegate;
	}
	public MonitorStationPOATie(MonitorStationOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
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
	public MonitorStationOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(MonitorStationOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		return super._default_POA();
	}
	public boolean get_status()
	{
		return _delegate.get_status();
	}

	public void set_status(boolean status)
	{
_delegate.set_status(status);
	}

	public java.lang.String get_location() throws clark.corba.InactiveStationException
	{
		return _delegate.get_location();
	}

	public double get_value() throws clark.corba.InactiveStationException
	{
		return _delegate.get_value();
	}

}
