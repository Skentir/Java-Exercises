public class Cow extends Mammal
{
    public static final int MAX_AGE = 25;

    public Cow(String name, int age)
    {
        super(name, age, MAX_AGE);
    }

    @Override
    public void makeSound()
    {
        System.out.println("Moo!");
    }
}
