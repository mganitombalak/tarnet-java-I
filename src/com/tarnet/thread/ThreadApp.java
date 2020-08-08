package com.tarnet.thread;


import lombok.val;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
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
//        executorSvc.shutdown(); //Gracefully Shutdown

        ExecutorService executor = Executors.newFixedThreadPool(3);
        val counter = new Counter();
        IntStream.range(0, 1000).forEach(t -> executor.execute(counter::Inc));
        executor.shutdown();
        executor.awaitTermination(1,TimeUnit.SECONDS);
        System.out.println("Total:" + counter.getValue());

//        ReentrantLock locker = new ReentrantLock();
//        executor.execute(()->{
//            locker.lock();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }finally {
//                locker.unlock();
//            }
//        });
//
//        executor.execute(()->{
//            System.out.println("IsLocked:"+locker.isLocked());
//            System.out.println("CurrentTheadIsLocker:"+locker.isHeldByCurrentThread());
//            System.out.println("DidILock?:"+locker.tryLock());
//        });
//        executor.shutdown();
//        executor.execute(inc2);
//        executor.shutdown();
//        System.out.println("Last value" + Counter.value);

        // Read/Write Lock //ReadWriteLock
        // StampedLock

//        List<Person> personList = new ArrayList<>();
//        //Thread-safe collection Stack,Hashtable,Vector
//
//        Collection<Person> syncPersonList = Collections.synchronizedList(personList);
//
//        BlockingQueue bq = new LinkedBlockingQueue();


//        List<MyCallable<String>> callables = Arrays.asList(
//                new MyCallable<String>(4,"Ahmet", 1),
//                new MyCallable<String>(2,"Adem", 2),
//                new MyCallable<String>(3,"Ersin", 3),
//                new MyCallable<String>(1,"Burcu", 4),
//                new MyCallable<String>(5,"Talat", 5),
//                new MyCallable<String>(6,"Beste", 6),
//                new MyCallable<String>(7,"Hilal", 7)
//        );
//
//        ExecutorService executor = Executors.newFixedThreadPool(2);

//        Future<String> f = executor.submit(GenerateCallable("Mehmet Gani",10));
//        try {
//            f.get();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        List<Callable<String>> ordered = callables
//                .stream()
//                .sorted(Comparator.comparingInt(MyCallable::getOrder))
//                .map(MyCallable::get).collect(Collectors.toList());
//
//        executor.invokeAll(ordered).stream().map(f -> {
//            try {
//                return f.get();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//                return null;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                return null;
//            }
//        }).forEach(System.out::println);
//        executor.shutdown();
//    }
//
//    private static Callable<String> GenerateCallable(String result, long sleep) {
//        return () -> {
//            System.out.println("Data:" + result + " Thread:" + Thread.currentThread().getId());
//            TimeUnit.SECONDS.sleep(sleep);
//            return result;
//        };
    }
}
