package com.company;

import java.util.HashMap;
import java.util.Map;

public class Leetcode242 {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        if(chars.length != chart.length)
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            map.merge(aChar,1,Integer::sum);
        }

        for (char c : chart) {
            if(map.get(c) != null){
                int integer = map.get(c) -1;
                if (integer == 0)
                    map.remove(c);
                else map.merge(c,-1,Integer::sum);
            }else return false;

        }
        return map.isEmpty();
    }


}
