package com.company;

import java.util.List;

public class HKArray2D {
    public static int hourglassSum(List<List<Integer>> arr) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i +2<arr.size() ; i++) {
            for (int j = 0; j +2 < arr.get(0).size(); j++) {
              max = Math.max(getSum(arr,i,j),max);
            }
        }
        return max;
    }

    public static  int getSum(List<List<Integer>> arr,int i, int j){
        return arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2) + arr.get(i + 1).get(j + 1) + arr.get(i+2).get(j) + arr.get(i+2).get(j + 1) + arr.get(i+2).get(j + 2);
    }
}
