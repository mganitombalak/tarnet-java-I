package com.tarnet.thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import lombok.Data;



@Data
public class Counter {
    private int value;
    public void Inc(){
        this.value++;

    }

    public void Dec(){
        this.value--;
    }
}
