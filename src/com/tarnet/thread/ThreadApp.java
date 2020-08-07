package com.tarnet.thread;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

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

        final List<Person> personList = Arrays.asList(
                new Person(1,"Gani"),
                new Person(2,"Harun"),
                new Person(3,"Ersin"),
                new Person(4,"Aykut"),
                new Person(5,"Ahmet"),
                new Person(6,"Beste"),
                new Person(7,"Burcu")
        );

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
//        CALLABLES


    }
}
