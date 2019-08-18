import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Driver
{
    private static <T> void shuffle(List<T> list)
    {
        Random random = new Random();
        for (int i = 0; i < list.size(); i++)
        {
            int j = i + random.nextInt(list.size() - i);
            T temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

    public static void main(String[] args)
    {
        ArrayList<Dog> cage = new ArrayList<>();
        ArrayList<Cow> fence = new ArrayList<>();
        ArrayList<Snake> terrarium = new ArrayList<>();

        List<Animal> barn = new ArrayList<>();


        barn.add(new Dog("Marty", 2));
        barn.add(new Dog("Ricky", 4));
        barn.add(new Cow("Moolah", 6));
        barn.add(new Cow("Davy", 8));
        barn.add(new Cow("Trisha", 1));
        barn.add(new Snake("Stitch", 3));
        //barn.add(new Animal("God", 100, 2147483647));

        shuffle(barn);

        for (Animal a : barn)
        {
            System.out.println("I am a/an " + a.getClass().getName());
            System.out.println("My name is " + a.getName());
            if (a instanceof Mammal) {
                System.out.println("I am a mammal");
            } else if (a instanceof Reptile) {
                System.out.println("I am a reptile");
            } else {
                System.out.println("I am neither a mammal nor a reptile");
            }
            System.out.println();

            if (a instanceof Dog)
            {
                cage.add((Dog) a);
            }
            else if (a instanceof Cow)
            {
                fence.add((Cow) a);
            }
            else if (a instanceof Snake)
            {
                terrarium.add((Snake) a);
            }
        }

        System.out.println("All dogs:");
        for (int i = 0; i < cage.size(); i++)
        {
            System.out.println("My name is " + cage.get(i).getName());
        }

        System.out.println("All cows:");
        for (int i = 0; i < fence.size(); i++)
        {
            System.out.println("My name is " + fence.get(i).getName());
        }

        System.out.println("All snakes:");
        for (int i = 0; i < terrarium.size(); i++)
        {
            System.out.println("My name is " + terrarium.get(i).getName());
        }
    }
}
