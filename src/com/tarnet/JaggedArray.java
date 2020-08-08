package com.tarnet;

public class JaggedArray {
    public static void main(String[] args) {
        int[][] array = new int[4][];
        for (int outer = 0; outer < array.length; outer++) {
            array[outer] = new int[outer+1];
        }
        for(int outer=0;outer< array.length;outer++){
            System.out.printf("%d. line: %d%n",outer,array[outer].length);
        }
    }
}
