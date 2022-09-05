package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    interface Foo {
        int x = 10;
    }


    public static void main(String[] args) {
        Integer[] a = new Integer[]{3,1,2,3};
        List<Integer> integers = Arrays.asList(a);
        System.out.println(functionExample(integers));
    }

    public static boolean functionExample(List<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        int max = numbers.get(0);
        int index = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (index > numbers.get(i)) {
                if (min < numbers.get(i))
                    return false;
                min = numbers.get(i);

            }
            else {
                if (max < numbers.get(i))
                    max = numbers.get(i);
                else return false;
            }
            index = numbers.get(i);

        }
        return true;
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;

        if (list1.val < list2.val) {
            return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
        } else {
            return new ListNode(list2.val, mergeTwoLists(list1, list2.next));
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


