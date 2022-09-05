package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static <T> List<List<T>> transpose(List<List<T>> list) {
        final int N = list.stream().mapToInt(l -> l.size()).max().orElse(-1);
        List<Iterator<T>> iterList = list.stream().map(it -> it.iterator()).collect(Collectors.toList());
        return IntStream.range(0, N)
                .mapToObj(n -> iterList.stream()
                        .filter(it -> it.hasNext())
                        .map(m -> m.next())
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public static void swap(List<List<Integer>> container, int index_1i, int index_1j, int index_2i, int index_2j) {

        int temp = container.get(index_1i).get(index_1j);
        container.get(index_1i).set(index_1j, container.get(index_2i).get(index_2j));
        container.get(index_2i).set(index_2j, temp);

    }

    public static String organizingContainers(List<List<Integer>> container) {
        List<List<Integer>> lstTemp = new ArrayList<>(container);
        List<List<Integer>> transpose = transpose(lstTemp);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < transpose.size(); i++) {
            map.put(i, transpose.get(i));
        }




        return "Possible";

    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Dao Manh\\IdeaProjects\\lean_300\\src\\com\\company\\resouces\\input01.txt")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

//                String result = Result.organizingContainers(container);
                Result.transpose(container).forEach(integers -> {
                    integers.forEach(integer -> System.out.print(integer + " "));
                    System.out.println();
                });
//                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

