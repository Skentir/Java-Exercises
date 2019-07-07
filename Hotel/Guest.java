/**
 * @(#)Guest.java
 *
 *
 * @author 
 * @version 1.00 2019/7/5
 */


public class Guest {

	private final String name;
	private final String nationality;

    public Guest(String name, String nationality) 
    {
    	this.name = name;
    	this.nationality = nationality;
    }
    
    public String getName()
    {
    	return name;
    }    	
    
    public String getNationality()
    {
    	return nationality;
    }
    
    @Override
    public String toString()
    {
    	return name + " - " + nationality;
    }
}