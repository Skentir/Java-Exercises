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
    if (amount < 0.0)
      currAmount = setMax(amount);
  }

  public setMax(double max) {
    if (max < 0.0)
      maxAmount = 10.0;
  }

}
