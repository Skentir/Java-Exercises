
/** The class Sanitizer represents a hand Sanitizer object
    with id, current amount, and max amount. The object
    can dispense and show the status of the sanitizer.

    @author Danielle Kirsten Sison
    @version 1.0
*/
public class Sanitizer {

  // attributes
  private final int id;
  private double currAmount;
  private double maxAmount;
/** This constructor receives the hand sanitizer's ID and
    max amount.
    @param  id an integer value that is non-negative
    @param max is a double value.
  */
  public Sanitizer (int id, double max) {
    setID(id);
    setCurr(max);
    setMax(max);
    this(id, currAmount, max);
  }
  /** This constructor initializes all attributes
    of the dog object.

    @param id an integer value
    @param amount a double value that
               should be non-negative
    @param max a double value that should be equal or greater
              than the current amount
  */
  public Sanitizer (int id, double amount, double max) {
    this.id = id;
    setCurr(amount);
    setMax(max);
  }
  /** This method assigns the int id as the id
      of the sanitizer.

    @param id an integer representing the sanitizer's id
    */
  public void setID(int id) {
    this.id = id;
  }
  /** This method assigns the double amount as the current amount
      of the sanitizer.

    @param amount a double value representing the current
      amount of the sanitizer
    */
  public void setCurr(double amount) {
    if (amount < 0.0)
      currAmount = setMax(amount);
  }
  /** This method assigns the double max as the maximum amount
      of the sanitizer.

    @param max a double value representing the maximum
      amount of the sanitizer
    */
  public void setMax(double max) {
    if (max < 0.0)
      maxAmount = 10.0;
  }
  /** This method returns the id of the sanitizer.

      @return id of sanitizer
  */
  public int getID() {
    return id;
  }
  /** This method returns the current amount of the sanitizer.

      @return current amount of sanitizer
  */
  public double getCurr() {
    return currAmount;
  }
  /** This method returns the maximum amount of the sanitizer.

      @return maximum amount of sanitizer
  */
  public double getMax() {
    return maxAmount;
  }
  /** This method returns all the values of the object as a String.

      @return String concatenation of id, current amount, and maximum amount
  */
  public String getStatus() {
    return id + ":" + getCurr() + "/" + getMax();
  }
  /** This method deducts 1% of the current amount of the sanitizer and returns it.

      @return 99% of current amount of sanitizer
  */
  public double dispense() {
    double new_amount = currAmount * 0.01;
    if (currAmount > new_amount) {
      currAmount -= new_amount;
      return new_amount;
    } else
      return currAmount; //dispense the remaining
  }
}
