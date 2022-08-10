import java.util.ArrayList;
import java.util.Collections;

public class Program
{
    public static long startTime; //Static to easily reference everywhere
    public static ArrayList<Person> persons = new ArrayList<>(); //Static to easily reference everywhere
    public static ArrayList<Operator> operators = new ArrayList<>(); //Static to easily reference everywhere
    public static Connection connection;

    public static void main(String[] args)
    {
        for (int i = 1; i <= 20 ; i++)
        {
            Person person = new Person("Person" + i);
            persons.add(person);
        }

        for (int i = 1; i <= 2 ; i++) //Initialize 6 books.
        {
            Operator book = new Operator("Operator " + i);
            operators.add(book);
        }

       connection = new Connection();

        startTime = System.nanoTime(); //Keep track of how long the simulation takes.

        Collections.shuffle(persons); //persons should speak his relative in a random order, that's why I shuffle.
        persons.forEach(Thread::start); //Start each person as new threads.
    }
}
