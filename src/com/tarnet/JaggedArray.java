package com.tarnet;

public class JaggedArray {
    public static void main(String[] args) {
        int[][] array = new int[7][9];

        for (int outer = 0; outer < array.length; outer++) {
            for (int x = 0; x < array[outer].length; x++) {
                array[outer][x / 2] = 0;
                if (array[outer][x] != 0)
                    array[outer][x] = 1;
            }

        }

        for (int outer = 0; outer < array.length; outer++) {
            System.out.printf("%d. line: %d%n", outer, array[outer].length);
        }

    }
}
