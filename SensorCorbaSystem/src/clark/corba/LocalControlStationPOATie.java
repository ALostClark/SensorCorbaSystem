package clark.corba;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "LocalControlStation".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public class LocalControlStationPOATie
	extends LocalControlStationPOA
{
	private LocalControlStationOperations _delegate;

	private POA _poa;
	public LocalControlStationPOATie(LocalControlStationOperations delegate)
	{
		_delegate = delegate;
	}
	public LocalControlStationPOATie(LocalControlStationOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
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
	public LocalControlStationOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(LocalControlStationOperations delegate)
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
	public java.lang.String[] get_stations()
	{
		return _delegate.get_stations();
	}

	public clark.corba.Entry[] get_logs()
	{
		return _delegate.get_logs();
	}

	public void register(java.lang.String location)
	{
_delegate.register(location);
	}

	public void report_value(java.lang.String location, double value)
	{
_delegate.report_value(location,value);
	}

	public java.lang.String get_location()
	{
		return _delegate.get_location();
	}

	public void unregister(java.lang.String location)
	{
_delegate.unregister(location);
	}

}
