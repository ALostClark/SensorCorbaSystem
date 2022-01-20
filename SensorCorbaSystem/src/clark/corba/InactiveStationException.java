package clark.corba;

/**
 * Generated from IDL exception "InactiveStationException".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at May 14, 2020, 11:50:52 AM
 */

public final class InactiveStationException
	extends org.omg.CORBA.UserException
{
	/** Serial version UID. */
	private static final long serialVersionUID = 1L;
	public InactiveStationException()
	{
		super(clark.corba.InactiveStationExceptionHelper.id());
	}

	public java.lang.String reason = "";
	public InactiveStationException(java.lang.String _reason,java.lang.String reason)
	{
		super(_reason);
		this.reason = reason;
	}
	public InactiveStationException(java.lang.String reason)
	{
		super(clark.corba.InactiveStationExceptionHelper.id());
		this.reason = reason;
	}
}
