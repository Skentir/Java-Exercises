import java.util.*;

public class Exercise4 {

    public static void main (String args[]) {
    	Scanner user_input = new Scanner(System.in);
    	System.out.print("Enter number of students: ");
    	int size = user_input.nextInt();
    	String[] directory = new String[size];
    	
    	// Populate the array
    	System.out.println("Enter in the format <lastName>, <firstName>, <initial>: ");
    	for (int i = 0; i < directory.length; i++) 
    		directory[i] = user_input.nextLine();
    		
    	// Sort the array
 		int indx, indx2; String surname, temp, firstname;
    	for (int n = 0; n < size; n++) {
    		indx = directory[n].indexOf(','); 
    		surname = directory[n].substring(0, indx);
    		
    		for (int m = n+1; m < size; m++){
    			if (surname.compareToIgnoreCase(directory[m]) > 0) {
    				temp = directory[m];
    				directory[m] = directory[n];
    				directory[n] = temp;
    			}
    		}
    		
    	}
    	
    	// Display the array
    	for (int m = 0; m < size; m++) {
    		indx = directory[m].indexOf(',') + 1;
    		indx2 = directory[m].lastIndexOf(',');
    		firstname = directory[m].substring(indx, indx2);
    		System.out.println(firstname);
    	}
    		
    	
    }
    
    
}
