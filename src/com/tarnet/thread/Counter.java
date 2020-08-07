package com.tarnet.thread;

import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;

@Data
public class Counter implements Runnable {

    private static ReentrantLock locker = new ReentrantLock();

    private int value;

    public void Inc() {
        locker.lock();
        try {
            this.value++;
        } finally {
            locker.unlock();
        }
    }

    public void Dec() {
        this.value--;
    }

    @Override
    public void run() {
        while(this.value<1000){
//            System.out.println("Thread:"+Thread.currentThread().getId() + " locked:"+locker.isLocked() + " isheld:"+ locker.isHeldByCurrentThread());
            this.Inc();
        }
    }
}
