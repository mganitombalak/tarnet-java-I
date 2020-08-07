package com.tarnet.thread;

import java.util.List;

public class Squared implements Runnable{
    private List<Double> arr;

    public Squared(List<Double> arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        this.arr.replaceAll(d->Math.pow(d,2));
    }
}
