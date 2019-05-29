import java.util.*;

public class Exercise3 {
  public static void main(String[] args){
    Scanner values = new Scanner(System.in);

    System.out.println("Enter values for");
    System.out.print("\ta: ");
    int a = values.nextInt();
    System.out.print("\tb: ");
    int b = values.nextInt();
    System.out.print("\tc: ");
    int c = values.nextInt();

    System.out.println("Results are: ");

    double Posresult = (-b + Math.sqrt(b*b - 4*a*c))/(2*a);
    double Negresult = (-b - Math.sqrt(b*b - 4*a*c))/(2*a);

    System.out.println("\t"+Posresult+" and");
    System.out.println("\t"+Negresult);

    values.close();
  }
}
