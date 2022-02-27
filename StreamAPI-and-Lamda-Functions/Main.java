package com.company;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.NoSuchElementException;

public class Main
{

    public static void main(String[] args)
    {
        System.out.println("Задание 1");
        List<Integer> list1 = List.of(-2, -1, 0, 1, 2);
        System.out.println(Tasks.taskAverageValue(list1));
        System.out.println();

        System.out.println("Задание 2");
        List<String> list2 = List.of("aaa", "BBB", "ccc");
        System.out.println(Tasks.taskUpperRegister(list2));
        System.out.println();

        System.out.println("Задание 3");
        List<Integer> list3 = List.of(0, 0, 0, 1, 2, 5, 2, 7, 1);
        System.out.println(Tasks.taskSingleNumberSquare(list3));
        System.out.println();

        System.out.println("Задание 4");
        List<String> list4 = List.of("aDDD", "bCCC", "cBBB", "aAAA");
        System.out.println(Tasks.taskAlphabetByChar(list4, "a"));
        System.out.println();

        System.out.println("Задание 5");
        List<Integer> list5 = List.of(13, 666, 777);
        Set<Integer> set5 = new TreeSet<>();
        try
        {
            System.out.println(Tasks.taskLastElement(list5));
            System.out.println(Tasks.taskLastElement(set5));
        }
        catch (NoSuchElementException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Задание 6");
        int[] mas6 = {2, 4, 5, 6, 4};
        System.out.println(Tasks.taskSumOfEven(mas6));
        mas6 = new int[]{7, 5, 777};
        System.out.println(Tasks.taskSumOfEven(mas6));
        System.out.println();

        System.out.println("Задание 7");
        List<String> list7 = List.of("a111", "b429", "c173", "q4F2");
        System.out.println(Tasks.taskListToMap(list7));
        System.out.println();

    }
}
