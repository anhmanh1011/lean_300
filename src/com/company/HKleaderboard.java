package com.company;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class HKleaderboard {
    public static void main(String[] args) throws IOException {


//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Dao Manh\\IdeaProjects\\lean_300\\src\\com\\company\\resouces\\input08.txt")));
//        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());
//        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());

//        List<Integer> ranked = new ArrayList<>(Arrays.asList(100, 100, 50, 40, 20, 10));
//        String inputRanked = "295 294 291 287 287 285 285 284 283 279 277 274 274 271 270 268 268 268 264 260 259 258 257 255 252 250 244 241 240 237 236 236 231 227 227 227 226 225 224 223 216 212 200 197 196 194 193 189 188 187 183 182 178 177 173 171 169 165 143 140 137 135 133 130 130 130 128 127 122 120 116 114 113 109 106 103 99 92 85 81 69 68 63 63 63 61 57 51 47 46 38 30 28 25 22 15 14 12 6 4";
        String inputRanked = "100 100 50 40 40 20 10";
//        String inputPlayed = "83 129 140 184 198 300 312 325 341 344 349 356 370 405 423 444 465 471 491 500 506 508 539 543 569 591 607 612 614 623 645 670 689 726 744 747 764 773 777 787 805 811 819 829 841 905 918 918 955 997";
        String inputPlayed = "5 25 50 120";
        List<String> inputRankedStr = Arrays.asList(inputRanked.split(" "));
        List<String> inputPlayedStr = Arrays.asList(inputPlayed.split(" "));
        List<Integer> collectRanked = inputRankedStr.stream().map(Integer::parseInt).collect(toList());
        List<Integer> collectPlayed = inputPlayedStr.stream().map(Integer::parseInt).collect(toList());
//        List<Integer> player = new ArrayList<>(Arrays.asList(5, 25, 50, 120));
        climbingLeaderboard(collectRanked, collectPlayed).forEach(System.out::println);

    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>();
        int rank = 1;
        int indexScore = player.size() - 1;
        int indexRank = 0;
        int preValue = Integer.MAX_VALUE;
        while (indexScore >= 0) {
            Integer valueScore = player.get(indexScore);
            while (indexRank < ranked.size() && valueScore < ranked.get(indexRank)) {
                if (preValue != ranked.get(indexRank))
                    rank++;
                preValue = ranked.get(indexRank);
                indexRank++;
            }

            indexScore--;
            result.add(rank);
        }
         Collections.reverse(result);
        return result;
    }

}
