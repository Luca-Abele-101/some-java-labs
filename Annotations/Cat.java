package com.company;

public class Cat
{
    @Pat(param = 3)
    private void meow()
    {
        System.out.println("Meow!");
    }

    @Pat(param = 1)
    private void lick()
    {
        System.out.println("The cat is licking milk");
    }

    @Pat(param = 1)
    private void purr()
    {
        System.out.println("Purr :3");
    }

    private void sleep()
    {
        System.out.println("The cat is sleeping");
    }


}
