package com.company;

import java.util.List;
import java.util.ArrayList;

import com.company.Classes.*;
import com.company.Exceptions.*;


public class Queue<T>
{
    private int size;
    private List<T> data;
    private final int capacity;

    public Queue(int capacity)
    {
        this.size = 0;
        this.data = new ArrayList<>(this.size);
        this.capacity = capacity;
    }

    public void add(T element)
    {
        if ((element == null) && (isEmpty()))
        {
            throw new EmptyQueue();
        }
        if (isFull())
        {
            throw new FullQueue();
        }
        data.add(element);
        size++;
    }

    public T get(int i)
    {
        if (isEmpty())
        {
            throw new EmptyQueue();
        }
        return data.get(i);
    }

    public Queue<? extends Aves> produce() throws FullQueue
    {
        Queue<Aves> queue = new Queue<>(13);
        for (Object obj : data)
        {
            if (obj instanceof Aves)
            {
                queue.add((Aves) obj);
            }
        }
        return queue;
    }

    public ArrayList<Queue<Aves>> consume(int n, List<? extends Aves> l) throws FullQueue
    {
        if (n > 4) n = 4;

        for (int i = 0; i < n; i++)
        {
            Queue<Aves> parents = new Queue<>(15);
            for (Aves obj : l)
            {
                if (!(obj instanceof GarrulusGlandarius) && (parents.getSize() < n-i))
                {
                    parents.add((Aves) obj);
                }
            }
            parents.printQueue();
            System.out.println();
        }

        ArrayList<Queue<Aves>> listOfQueue = new ArrayList<>();
        return listOfQueue;
    }

    public int getSize()
    {
        return size;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public boolean isFull()
    {
        return size >= capacity;
    }

    public boolean isEmpty()
    {
        return data.isEmpty();
    }

    public void printQueue()
    {
        for (int i = 0; i < getSize(); i++)
        {
            System.out.println(this.get(i));
        }
    }

}
