package lab7;

import java.util.concurrent.ThreadFactory;

public class ReaderThreadFactory implements ThreadFactory
{
    private int counter = 0;

    @Override
    public Thread newThread(Runnable r)
    {
        return new Thread(r, "Reading thread " + counter++);
    }
}
