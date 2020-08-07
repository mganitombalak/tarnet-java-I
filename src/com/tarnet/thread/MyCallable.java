package com.tarnet.thread;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class MyCallable<T> {
    private int order;
    private T result;
    private long sleepTime;

    public Callable<T> get() {
        return () -> {
            System.out.println("Data:" + result + " Thread:" + Thread.currentThread().getId());
            TimeUnit.SECONDS.sleep(sleepTime);
            return result;
        };
    }
}
