package com.tarnet.thread;


import com.github.javafaker.Faker;
import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class ThreadApp {
    public static void main(String[] args) throws InterruptedException { //MAIN
        // Thread
        // Runnable FireAndForget
//        Thread t = new Thread(new Runnable() { //Anonymous Class is generating in here
//            @SneakyThrows
//            @Override
//            public void run() {
//                Thread.sleep(2000);
//                System.out.printf("%s ThreadName:%s ThreadId:%s%n",
//                        "This text is written by another thread!",
//                        Thread.currentThread().getName(),
//                        Thread.currentThread().getId());
//            }
//        }, "My Stupid Thread");
//        t.start();
//        System.out.println("Application is running");
//        t.join();
//        System.out.println("All Done!");
        // BUSINESS LOCKED

//        List<Double> arr = Arrays.asList(1D, 2D, 3D, 4D, 5D, 6D, 7D, 8D, 9D);
//        System.out.println("Before");
//        arr.forEach(System.out::println);
//        System.out.println("Result");
//        //arr.parallelStream().map(d->d*d).forEach(System.out::println);
//        Thread s =new Thread(new Squared(arr));
//        s.start();
//        s.join();
//        System.out.println("After");
//        arr.forEach(System.out::println);

//        final List<Person> personList = new ArrayList<>();
//        IntStream.range(0, 100).parallel().forEach(id -> {
//            personList.add(new Person(id, Faker.instance().name().fullName(), (id % 5 == 0 ? "HR" : "IT"), Faker.instance().number().randomDouble(2, 1, 15000)));
//        });

//        System.out.println("OK");
//        RUNNABLES

//        Runnable r1 = ()-> personList.parallelStream().forEach(System.out::println);//personList.stream().forEach(System.out::println);
//        Thread t1 = new Thread(r1);
//        t1.start();
//        t1.join();
//------------------------------------------------------------------------------------
//        Runnable r = ()-> personList.forEach(Person::print);
//        Thread t1 = new Thread(r);
//        t1.start();
//        t1.join();
//-------------------------------------------------------------------------------------
//        Runnable r = ()->{
//            Consumer<Person> consumer= p-> System.out.println("Id:"+p.getId()+" Name:"+p.getName());
//            personList.forEach(consumer);
//        };
//
//        Thread t1 = new Thread(r);
//        t1.start();
//        t1.join();
//


//        Thread t1 = new Thread(salaryUpdate);
//        long startTime = System.currentTimeMillis();
//        t1.start();
//        t1.join();
//        long endTime = System.currentTimeMillis() - startTime;
//        System.out.printf("Operation complete in %d ms", endTime);

//        THREAD POOLING
//        EXECUTOR & SYNC

//        ExecutorService executorSvc = Executors.newFixedThreadPool(2);//new ThreadPoolExecutor()
//        Runnable salaryUpdate = () -> {
//            System.out.println("Salary:" + Thread.currentThread().getId());
//            Consumer<Person> priceUpdater = (Person p) -> p.setSalary(p.getSalary() * (p.getDepartment().equals("HR") ? 1.05 : 1.1));
////            personList.parallelStream().forEach(priceUpdater);
//            personList.forEach(priceUpdater);
//        };
//        Runnable printer = () -> {
//            System.out.println("Printing:" + Thread.currentThread().getId());
//            personList.forEach(System.out::println);
//        };
//        Runnable r = () -> {
//            System.out.println("R:" + Thread.currentThread().getId());
//            personList.forEach(p -> p.getDepartment());
//        };
//        System.out.println("Printing Phase is about to initiate.");
//        executorSvc.execute(printer);
//        System.out.println("Salary Update Phase is about to initiate.");
//        executorSvc.execute(salaryUpdate);
//        System.out.println("Deparment Printing Phase is about to initiate.");
//        executorSvc.execute(r);
//        executorSvc.shutdown();

        ExecutorService executor = Executors.newSingleThreadExecutor();

        final val counter =new Counter();

        Runnable inc = ()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter.Inc();
        };
        Runnable dec=()->{
            try {
                Thread.sleep(2200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter.Dec();
        };


    }
}
