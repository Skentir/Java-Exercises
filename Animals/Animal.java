public abstract class Animal
{
    public static final int MAX_AGE = 100;

    private String name;
    private int age;
    private int maxAge;

    private Animal(int maxAge)
    {
        this.maxAge = maxAge;
    }

    protected Animal(String name, int age, int maxAge)
    {
        this(maxAge);
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public void getOld()
    {
        if (age >= maxAge)
        {
            System.out.println("I'm dead.");
        }
        else
        {
            age++;
            System.out.println("I am " + age + " year(s) old");
        }
    }

    public void makeSound() {}
}
