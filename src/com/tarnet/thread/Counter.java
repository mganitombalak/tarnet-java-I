package com.tarnet.thread;

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
