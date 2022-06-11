package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Tasks {

    public static double taskAverageValue(List<Integer> l)
    {
        return l.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics()
                .getAverage();
    }

    public static List<String> taskUpperRegister(List<String> l)
    {
        return l.stream()
                .map(str -> str.toUpperCase())
                .map(str -> "_new_" + str)
                .toList();
    }

    public static List<Integer> taskSingleNumberSquare(List<Integer> l)
    {
        return l.stream()
                .filter(num -> l.indexOf(num) == l.lastIndexOf(num))
                .map(a -> a * a).toList();
    }

    public static List<String> taskAlphabetByChar(Collection<String> col, String initLetter)
    {
        return col.stream()
                .filter(n -> n.startsWith(initLetter))
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .toList();
    }

    public static <T> T taskLastElement(Collection<T> col)
    {
        return col.stream()
                .reduce((a, b) -> b)
                .orElseThrow(() -> new NoSuchElementException("Коллекция пуста"));
    }

    public static int taskSumOfEven(int[] a)
    {
        return Arrays.stream(a)
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static Map<Character, String> taskListToMap(List<String> l)
    {
        return l.stream()
                .collect(Collectors.toMap(str -> str.charAt(0), str -> str.substring(1)));
    }
}
