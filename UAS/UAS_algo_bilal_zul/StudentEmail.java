//author Bilal Abdul QOwy 1910130007
//author M Akbar Riandi 1910130011
//author Zulfikri M 1810130008



public class StudentEmail
{
   public static final String EMAIL_STUB = "@student.esqbs.ac.id";

   private String name;
   private String id;

   public StudentEmail ()
   {
      name = "";
      id   = "";
   }

   public StudentEmail (String name, String id)
                        throws StudentEmailException
   {
      // Remove elading and trailing spaces, tabs.
      name = name.trim ();
      id   = id.trim ();

      if (name.length () == 0)
      {
         //JOptionPane.showMessageDialog (null, "Error: name cannot be blank.");
         throw new StudentEmailException ("Error: nama harus terisi.");
      }

      else if (id.length () == 0)
      {
         //JOptionPane.showMessageDialog (null, "Error: Id cannot be blank.");
         throw new StudentEmailException ("Error: id harus terisi.");
      }

      else
      {
         // All is OK, set class data to the values passed in.
         this.name = name;
         this.id   = id;
      }
   }

   public String getName ()
   {
      return name;
   }

   public String getId ()
   {
      return id;
   }

   public void setName (String name)
   {
      this.name = name;
   }

   public void setId (String id)
   {
      this.id = id;
   }

   @Override
   public String toString ()
   {
      return id + "\t" + name + "\t" + id + EMAIL_STUB;
   }

} // public class StudentEmail