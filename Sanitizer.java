public class Sanitizer {

  // attributes
  private final int id;
  private double currAmount;
  private double maxAmount;

  public Sanitizer (int id, double max) {
    this.id = id;
    this.currAmount = ;
    setMax(max);
    this(id, currAmount, max);
  }

  public Sanitizer (int id, double amount, double max) {
    this.id = id;
    setCurr(amount);
    setMax(max);
  }

  setCurr(double amount) {
    currAmount = amount;
  }

  setMax(double max) {
    maxAmount = max;
  }

}
