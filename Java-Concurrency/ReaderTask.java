package lab7;

import java.util.concurrent.BlockingQueue;

public class ReaderTask implements Runnable
{
    private final BlockingQueue<String> queue;

    public ReaderTask(BlockingQueue<String> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        Functions.pause(1000, 2000);
        System.out.print(Thread.currentThread().getName() + ": has read ");
        try
        {
            System.out.println(queue.take());
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
