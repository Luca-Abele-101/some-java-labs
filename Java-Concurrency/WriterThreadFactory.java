package lab7;

import java.util.concurrent.ThreadFactory;

public class WriterThreadFactory implements ThreadFactory
{
    private int counter = 0;

    @Override
    public Thread newThread(Runnable r)
    {
        return new Thread(r, "Writing thread " + counter++);
    }
}
