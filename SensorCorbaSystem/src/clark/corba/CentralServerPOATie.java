package clark.corba;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "CentralServer".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public class CentralServerPOATie
	extends CentralServerPOA
{
	private CentralServerOperations _delegate;

	private POA _poa;
	public CentralServerPOATie(CentralServerOperations delegate)
	{
		_delegate = delegate;
	}
	public CentralServerPOATie(CentralServerOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
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
	public CentralServerOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(CentralServerOperations delegate)
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
	public void register(java.lang.String location)
	{
_delegate.register(location);
	}

	public java.lang.String get_location()
	{
		return _delegate.get_location();
	}

	public void raise_alarm(java.lang.String control_station)
	{
_delegate.raise_alarm(control_station);
	}

	public void unregister(java.lang.String location)
	{
_delegate.unregister(location);
	}

}
