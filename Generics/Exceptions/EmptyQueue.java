package com.company.Exceptions;

public class EmptyQueue extends RuntimeException
{
    public EmptyQueue()
    {
        super ("Queue is empty");
    }
}
