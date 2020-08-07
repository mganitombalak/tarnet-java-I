package com.tarnet;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TimingSample {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        List<Integer> l = (List<Integer>) IntStream.range(0, 10000).boxed().collect(Collectors.toList());
        long endTime = System.currentTimeMillis() - startTime;
        System.out.printf("1. Operation completed in %d ms", endTime);
        long startTime1 = System.currentTimeMillis();
        IntStream.range(0, 10000).map(t -> t * 2).forEach(System.out::println);
        long endTime2 = System.currentTimeMillis() - startTime1;
        System.out.printf("2. Operation completed in %d ms", endTime2);
    }
}
