package appA.idl;

/**
* idl/AServiceHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from src/main/java/appA/idl/AService.idl
* Thursday, March 13, 2025 1:26:02 PM TRT
*/

public final class AServiceHolder implements org.omg.CORBA.portable.Streamable
{
  public appA.idl.AService value = null;

  public AServiceHolder ()
  {
  }

  public AServiceHolder (appA.idl.AService initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = appA.idl.AServiceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    appA.idl.AServiceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return appA.idl.AServiceHelper.type ();
  }

}
