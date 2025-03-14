package appB.idl;


/**
* idl/BServiceHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from src/main/java/appB/idl/BService.idl
* Thursday, March 13, 2025 1:59:56 PM TRT
*/

abstract public class BServiceHelper
{
  private static String  _id = "IDL:idl/BService:1.0";

  public static void insert (org.omg.CORBA.Any a, appB.idl.BService that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static appB.idl.BService extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (appB.idl.BServiceHelper.id (), "BService");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static appB.idl.BService read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_BServiceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, appB.idl.BService value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static appB.idl.BService narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof appB.idl.BService)
      return (appB.idl.BService)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      appB.idl._BServiceStub stub = new appB.idl._BServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static appB.idl.BService unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof appB.idl.BService)
      return (appB.idl.BService)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      appB.idl._BServiceStub stub = new appB.idl._BServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
