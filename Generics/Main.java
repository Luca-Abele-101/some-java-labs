package com.company;

import com.company.Classes.*;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        Queue<Animalia> q = new Queue<>(13);
        q.add(new Chordata());
        q.add(new Aves());
        q.add(new Passeriformes());
        q.add(new Corvidae());
        q.add(new Garrulus());
        q.add(new GarrulusGlandarius());

        q.printQueue();
        System.out.println();

        Queue<? extends Aves> prodResult = q.produce();
        prodResult.printQueue();
        System.out.println();

        List<Aves> l = List.of(new Aves(), new Passeriformes(), new Corvidae(), new Garrulus(), new GarrulusGlandarius());
        prodResult.consume(3, l);

    }
}
