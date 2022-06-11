package com.company;

import java.util.Random;

public class Program
{
    private static ProgramState state = ProgramState.RUNNING;
    private static final Object mutex = new Object();
    private static Thread abstractProgram = new Thread(new AbstractProgram());

    static class AbstractProgram implements Runnable
    {
        @Override
        public void run()
        {
            Thread daemon = new Thread(() -> {
                while (true)
                {
                    pause(1000, 5000);
                    if (abstractProgram.isInterrupted())
                    {
                        break;
                    }
                    synchronized (mutex)
                    {
                        state = ProgramState.values()[new Random().nextInt(ProgramState.values().length)];
                        if (state.equals(ProgramState.RUNNING))
                        {
                            System.out.println("Демон: Программа осталась в состоянии RUNNING");
                        }
                        else
                        {
                            System.out.println("Демон: Состояние программы изменено на: " + state.toString());
                        }
                        mutex.notify();
                    }
                }
            });
            daemon.setDaemon(true);
            daemon.start();
            System.out.println("Абстрактная программа и Демон запущены");

            while (!Thread.currentThread().isInterrupted())
            {
                foo();
            }
        }

        private void foo() // just doing some work
        {
            int tmp = 0;
            tmp=777;
            tmp=0;
        }
    }

    static class Supervisor implements Runnable
    {
        @Override
        public void run()
        {
            System.out.println("Супервизор запущен");
            abstractProgram.start();
            while (!abstractProgram.isInterrupted())
            {
                synchronized (mutex)
                {
                    try
                    {
                        mutex.wait();
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    switch (state)
                    {
                        case FATAL_ERROR -> stopProgram();
                        case UNKNOWN, STOPPING -> runProgram();
                        default -> System.out.println("Супервизор: пока что бездействую");
                    }
                }
            }
        }

        private void runProgram()
        {
            state = ProgramState.RUNNING;
            System.out.println("Супервизор: Программа перезапущена");
        }

        private void stopProgram()
        {
            abstractProgram.interrupt();
            System.out.println("Супервизор: программа остановлена");
        }
    }

    public static void pause(int lowerBound, int upperBound) // pause for daemon activity
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
