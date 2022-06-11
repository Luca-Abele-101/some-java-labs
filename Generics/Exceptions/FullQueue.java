package com.company.Exceptions;

public class FullQueue extends RuntimeException
{
    public FullQueue()
    {
        super ("Queue is full");
    }
}
