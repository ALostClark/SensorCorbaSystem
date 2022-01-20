package clark.orbs;

import clark.corba.LocalControlStationHelper;
import clark.portable.LocalControlStation;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class LocalStationOrb {

    private ORB orb;
    private Object nameServiceObject;
    private NamingContextExt namingContextExt;
    private POA portableObjectAdapter;

    public LocalStationOrb(String[] args) {
        try {
            orb = ORB.init(args, null);

            // get reference to rootpoa & activate the POAManager
            portableObjectAdapter = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            portableObjectAdapter.the_POAManager().activate();

            // Get a reference to the Naming service
            nameServiceObject = orb.resolve_initial_references("NameService");
            if (nameServiceObject == null) {

                return;
            }

            // Use NamingContextExt which is part of the Interoperable
            // Naming Service (INS) specification.
            namingContextExt = NamingContextExtHelper.narrow(nameServiceObject);
            if (namingContextExt == null) {

                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TODO: Change
    public void bindObjectToName(String name, LocalControlStation station) throws ServantNotActive, WrongPolicy, CannotProceed, InvalidName, NotFound {
        Object ref = portableObjectAdapter.servant_to_reference(station);

        NameComponent[] stationName = namingContextExt.to_name(name);
        namingContextExt.rebind(stationName, LocalControlStationHelper.narrow(ref));
    }

    // TODO: Change
    public clark.corba.LocalControlStation getObjectAtReference(String name) throws CannotProceed, InvalidName, NotFound {
        return LocalControlStationHelper.narrow(namingContextExt.resolve_str(name));
    }

    public void runServer() { orb.run(); }
}
