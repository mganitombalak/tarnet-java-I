package com.tarnet.thread;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Person {
    private int id;
    private String name;
    public void print(){
        System.out.printf("id:%d - Name:%s%n",this.getId(),this.getName());
    }
}
