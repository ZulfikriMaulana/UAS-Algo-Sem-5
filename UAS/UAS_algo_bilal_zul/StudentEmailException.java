//author Bilal Abdul QOwy 1910130007
//author M Akbar Riandi 1910130011
//author Zulfikri M 1810130008

public class StudentEmailException extends Exception
{

   public StudentEmailException ()
   {
      super ();
   }

   public StudentEmailException (String message)
   {
      super (message);
   }

   public StudentEmailException (Throwable cause)
   {
      super (cause);
   }

   public StudentEmailException (String message, Throwable cause)
   {
      super (message, cause);
   }
}