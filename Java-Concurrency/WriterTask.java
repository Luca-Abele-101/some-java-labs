package lab7;

import java.util.concurrent.BlockingQueue;

public class WriterTask implements Runnable
{

    private final BlockingQueue<String> queue;
    private static int num = 0;

    public WriterTask(BlockingQueue<String> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        Functions.pause(700, 1000);
        String message = "\"Message " + num++ + "\"";
        System.out.println(Thread.currentThread().getName() + ": is trying to write: " + message);
        try
        {
            queue.put("message from " + Thread.currentThread().getName() + ": " + message);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
