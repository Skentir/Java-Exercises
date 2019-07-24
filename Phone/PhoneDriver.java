import java.util.*;

public class PhoneDriver {

  public static void main(String[] args)
  {
    Phone p1, p2;
    MobilePhone m1, m2;

    p1 = new Phone(20765);
    m1 = new MobilePhone(9317492);

    /*EXPERIMENTS*/
    System.out.println(m1 instanceof Phone); // Prints true
    /* Experiment 2*/
    System.out.println(p1 instanceof MobilePhone); // Prints false
    /* Experiment 3 */
    m2 = new MobilePhone(2468274);
    m1.sendSMS("Hello", m2);
    System.out.println(m2.displaySMS());
  }
}
