package com.company;

public class Naver_60057 {
    public static void main(String[] args) {
        String input = "aabbaccc";
        System.out.println(solution(input));
        input = "ababcdcdababcdcd";
        System.out.println(solution(input));
        input = "abcabcdede";
        System.out.println(solution(input));
        input = "abcabcabcabcdededededede";
        System.out.println(solution(input));
        input = "xababcdcdababcdcd";
        System.out.println(solution(input));
    }


    public static int solution(String s) {
        System.out.println(s);
        int shortest = s.length();
        for (int i = 1; i <= s.length() / 2 + 1; i++) {
            int localDuplicate = 1;
            int index = i;
            int shortLocal = 0;
            String localStr = s.substring(0, index);
            while (index < s.length() - i) {
                String substring = s.substring(index, index + i);
                if (localStr.equals(substring)) {
                    localDuplicate++;
                } else {
                    if (localDuplicate > 1) {
                        shortLocal += localDuplicate / 10 + 1 + i;
                    } else {
                        shortLocal += i;
                    }
                    localDuplicate = 1;
                    localStr = substring;
                }
                index += i;
            }
            String endSub = s.substring(index);
            if (localStr.equals(endSub)) {
                localDuplicate++;
                shortLocal += localDuplicate / 10 + 1 + i;
            } else {
                shortLocal += s.substring(index - i).length();
            }

            if (shortLocal < shortest) {
                shortest = shortLocal;
            }
        }

        return shortest;
    }


}
