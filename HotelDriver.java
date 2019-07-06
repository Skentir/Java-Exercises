/**
 * @(#)HotelDriver.java
 *
 *
 * @author 
 * @version 1.00 2019/7/5
 */

import java.util.*;

public class HotelDriver {

    public static void main(String[] args) {
    	Guest[] people = new Guest[5];
    	people[0] = new Guest("Leena", "Finnish");
    	people[1] = new Guest("Simba", "Africa");
    	people[2] = new Guest("Takahashi", "Japan");
    	people[3] = new Guest("Yonradee", "Thailand");
    	people[4] = new Guest("Janbee", "Filipino");
    	
    	System.out.println("Initialized People ");
    	
    	Hotel shang = new Hotel("Shangri-La", 4);
   
    	shang.acceptGuest(people[0], 1);
    	shang.acceptGuest(people[1], 1);
    	shang.acceptGuest(people[2], 1);
    		
    }
    
    
}