package com.tarnet.oop;

public class HugeNamedBuffer extends NamedBuffer {
    protected HugeNamedBuffer(String pName) {
        super(pName);
        this.name=pName;
        this.capacity=1000;
    }
}
