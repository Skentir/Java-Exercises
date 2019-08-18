public class Dog extends Mammal
{
    public static final int MAX_AGE = 15;

    public Dog(String name, int age)
    {
        super(name, age, MAX_AGE);
    }

    @Override
    public void makeSound()
    {
        System.out.println("Woof!");
    }
}
