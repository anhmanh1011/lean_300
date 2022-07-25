package com.company;

import java.util.Arrays;

public class Leetcode733 {
    public static void main(String[] args) {
        int[][] input = new int[6][6];
        for (int i = 0; i < input.length; i++) {
            Arrays.fill(input[i], 1);
        }
        Arrays.fill(input[5], 2);

        printMatrix(input);
        System.out.println();
        printMatrix(floodFill(input, 1, 1, 3));
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length - 1;
        int n = image[0].length - 1;
        int oldValue = image[sr][sc];
        if(oldValue == color)
            return image;

        image[sr][sc] = color;

        if (sr > 0 && image[sr - 1][sc] == oldValue) {
            floodFill(image, sr - 1, sc, color);
        }
        //below
        if (sr < m && image[sr + 1][sc] == oldValue) {
            floodFill(image, sr + 1, sc, color);
        }

        // left
        if (sc > 0 && image[sr][sc - 1] == oldValue) {
            floodFill(image, sr, sc - 1, color);
        }

        // right
        if (sc < n && image[sr][sc + 1] == oldValue) {
            floodFill(image, sr, sc + 1, color);
        }
        return image;
    }
}
