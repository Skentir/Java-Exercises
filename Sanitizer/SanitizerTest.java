import java.util.*;

public SanitizerTest {
  public static void main(String[] args)
  {
    Sanitizer first = new Sanitizer(1, 50);
    Sanitizer second = new Sanitizer(2, 100);

    while(first.getCurr > 0)
    {
      System.out.println("First: " + first.dispense());
      System.out.println(first.toString());
    }
    while(second.getCurr > 0) {
      System.out.println("Second: " + second.dispense());
      System.out.println(second.toString());
    }

  }
}
