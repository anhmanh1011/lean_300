package com.company;

import java.io.IOException;
import java.util.*;

public class Left_Rotation {
    public static void main(String[] args)  {
        List<Integer> integers = Arrays.asList(1, 2, 3,4,5);
        System.out.println(rotLeft(integers,4));
    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        List<Integer> result = new ArrayList<>(a.size());
        List<Integer> integers = a.subList(d, a.size());
        List<Integer> integers1 = a.subList(0, d);
        result.addAll(integers);
        result.addAll(integers1);
        return result;
    }

}
