package com.company;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args)
    {
        Cat barsik = new Cat();
        for (Method i : barsik.getClass().getDeclaredMethods())
        {
            try
            {
                if (i.isAnnotationPresent(Pat.class))
                {
                    i.setAccessible(true);
                    Pat hand = i.getAnnotation(Pat.class);
                    int j = hand.param();
                    while (j > 0)
                    {
                        i.invoke(barsik);
                        j--;
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println(e.toString());
            }
        }

    }
}
