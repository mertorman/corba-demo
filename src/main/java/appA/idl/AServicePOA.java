package appA.idl;


/**
* idl/AServicePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from src/main/java/appA/idl/AService.idl
* Thursday, March 13, 2025 1:26:02 PM TRT
*/

public abstract class AServicePOA extends org.omg.PortableServer.Servant
 implements appA.idl.AServiceOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("processRequest", new java.lang.Integer (0));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // idl/AService/processRequest
       {
         String request = in.read_string ();
         String $result = null;
         $result = this.processRequest (request);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:idl/AService:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public AService _this() 
  {
    return AServiceHelper.narrow(
    super._this_object());
  }

  public AService _this(org.omg.CORBA.ORB orb) 
  {
    return AServiceHelper.narrow(
    super._this_object(orb));
  }


} // class AServicePOA
