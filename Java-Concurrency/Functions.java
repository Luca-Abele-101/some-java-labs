package lab7;

import java.util.Random;

public class Functions
{
    public static void pause(int lowerBound, int upperBound)
    {
        try
        {
            Thread.sleep(new Random().nextInt(upperBound - lowerBound) + lowerBound);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
