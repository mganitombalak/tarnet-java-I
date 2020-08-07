package com.tarnet.thread;


import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
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

        final List<Person> personList = new ArrayList<>();
        IntStream.range(0, 10000).parallel().forEach(id -> {
            personList.add(new Person(id, Faker.instance().name().fullName(), (id % 5 == 0 ? "HR" : "IT"), Faker.instance().number().randomDouble(2, 1, 15000)));
        });

        System.out.println("OK");
        Runnable r1=()-> personList.parallelStream().forEach(id->{
            if(personList.get(id.getId()).getDepartment().equals("IT")){
                personList.get(id.getId()).setSalary((personList.get(id.getId()).getSalary()*(0.05)));
            }else{
                personList.get(id.getId()).setSalary((personList.get(id.getId()).getSalary()*(0.10)));
            }
        });
        Thread s=new Thread(r1);
        s.start();
        s.join();
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
