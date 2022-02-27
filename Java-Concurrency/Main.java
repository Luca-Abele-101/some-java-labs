package lab7;

import java.util.concurrent.*;

public class Main
{
    public static final int CAPACITY = 10;
    public static final int MSG_AMOUNT = 20;

    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            throw new IllegalArgumentException();
        }
        int n = Integer.parseInt(args[0]);

        BlockingQueue<String> queue = new LinkedBlockingQueue<>(CAPACITY);

        ExecutorService writers = Executors.newFixedThreadPool(n, new WriterThreadFactory());
        ExecutorService readers = Executors.newFixedThreadPool(n, new ReaderThreadFactory());

        for (int i = 0; i < MSG_AMOUNT; i++)
        {
            writers.execute(new WriterTask(queue));
            readers.execute(new ReaderTask(queue));
        }

        writers.shutdown();
        readers.shutdown();
    }
}
