import java.util.ArrayList;
import java.util.Random;

public class Utils
{
    public static <T> T getRandomElementFromArrayList(ArrayList<T> arrayList) // I use this to get random elements from any ArrayList I give this method.
    {
        int index = getRandomIntegerBetween(0, arrayList.size()-1);

        return arrayList.get(index);
    }

    public static int getRandomIntegerBetween(int min, int max) //Returns a random integer between min and max (Min and Max Included)
    {
        Random random = new Random();

        return random.nextInt(max + 1 - min) + min;
    }

    public static void printTotalRuntime()
    {
        long endTime = System.nanoTime(); //This method gets called when all the person threads end, so I save the ending time after the last person finishes.

        double duration = (endTime - Program.startTime); //Calculate duration

        duration = (duration / Math.pow(10, 9)); //Turn nanoseconds into seconds

        System.out.printf("""
                ╔═══════════════════════════════════════════════════════════════════════════════════════════════╗
                ║⋆ The simulation is over, all 20 persons managed to spoke all his relative                     ║
                ║⋆ The simulation took: %.2f seconds!                                                          ║
                ╚═══════════════════════════════════════════════════════════════════════════════════════════════╝""", duration);
    }
}
