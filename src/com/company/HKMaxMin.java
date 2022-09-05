package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class HKMaxMin {
    public static void main(String[] args) throws IOException {
       List<Integer> integers = Arrays.asList(10, 100, 300,200,1000,20,30);
        System.out.println(maxMin(3,integers));
    }

    public static int maxMin(int k, List<Integer> arr) {
        Collections.sort(arr);
        System.out.println(arr);
        int result = Integer.MAX_VALUE;
        for (int i = 0; (i+k-1)<arr.size(); i++) {
            result = Math.min(arr.get(i+k-1)-arr.get(i),result);
        }
        return result;

    }

}
