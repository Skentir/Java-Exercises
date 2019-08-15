public class Person
{
   public Person(String n, String g, int a)
   {
	  spouse = null;
	  name = n;
      age = 18;
      setAge(a);
      if (g.equalsIgnoreCase("male") ||
		      g.equalsIgnoreCase("female"))
			gender = g;
	  else
	  {
		  System.out.println(g +
		       " not a valid gender");
		  gender = "male";
	  }
   }

   public Person getSpouse()
   {   return spouse;
   }

   public String getName()
   {
	   return name;
   }

   public int getAge()
   {
           return age;
   }

   public void setAge(int a)
   {
          if (a >= 18)
             age = a;
   }

   public String toString()
   {
	   if (spouse != null)
		   return name + ", " +  age + ", is married to " +
	              spouse.getName();
	   else return name + ", " +  age + ", is not married ";
   }

   public String getGender()
   {
	   return gender;
   }

   public void marry(Person p)
   {
	   if (spouse == null && p.getSpouse() == null &&
               p != this &&
	       gender.equalsIgnoreCase(p.gender) == false)
		      {spouse = p;p.spouse = this;}
	   else System.out.println("Cannot marry");
   }

   private final String name;
   private final String gender;
   private int age;
   private Person spouse;
}
