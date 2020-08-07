package com.tarnet;

import com.tarnet.thread.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TimingSample {
    public static void main(String[] args) {

//        List<Person> personList = new ArrayList<>();
//        Collection<Person> synchronizedList = Collections.synchronizedList(personList);
//
//        long startTime = System.currentTimeMillis();
//        List<Integer> l = (List<Integer>) IntStream.range(0, 10000).boxed().collect(Collectors.toList());
//        long endTime = System.currentTimeMillis() - startTime;
//        System.out.printf("1. Operation completed in %d ms", endTime);
//        long startTime1 = System.currentTimeMillis();
//        IntStream.range(0, 10000).map(t -> t * 2).forEach(System.out::println);
//        long endTime2 = System.currentTimeMillis() - startTime1;
//        System.out.printf("2. Operation completed in %d ms", endTime2);
    }
}
