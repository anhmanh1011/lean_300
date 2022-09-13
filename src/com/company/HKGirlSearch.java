package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HKGirlSearch {

    public static void main(String[] args) {
//        List<String> strG = Arrays.asList("7283455864", "6731158619", "8988242643", "3830589324", "2229505813","5633845374","6473530293","7053106601");
        List<String> strG = Arrays.asList("123412", "561212", "123634", "781288");
//        List<String> strP = Arrays.asList("9505", "3845", "3530");
        List<String> strP = Arrays.asList("12", "34");
        System.out.println(gridSearch(strG, strP));
    }

    public static String gridSearch(List<String> G, List<String> P) {

        int i = 0;

        while (i < G.size()) {
            int indexP = 0;
            Set<Integer> setIndex = new HashSet<>();

            while (i < G.size() && indexP < P.size() && G.get(i).contains(P.get(indexP))) {
                int i1 = G.get(i).indexOf(P.get(indexP), 0);
                setIndex.add(G.get(i).indexOf((P.get(indexP))));
                i++;
                indexP++;

            }
            if (indexP == P.size() && setIndex.size() == 1) {
                return "YES";
            }
            if (indexP == 0)
                i++;
        }
        return "NO";
    }

}
