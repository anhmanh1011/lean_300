package com.company;

public class LeetCode125 {
    public static void main(String[] args) {

        String input = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(input));
    }

    public static boolean isPalindrome(String s) {
        char[] chars = s.trim().toLowerCase().replaceAll("[^a-z0-9]", "").toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            if(chars[i]!= chars[chars.length-i-1])
                return false;
        }
        return true;
    }

}
