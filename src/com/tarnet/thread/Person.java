package com.tarnet.thread;

import lombok.*;


@Data
@AllArgsConstructor
@Builder
public class Person {
    private int id;
    private String name;
    private String department;
    private double salary;

    public void print(){
        System.out.printf("id:%d - Name:%s%n",this.getId(),this.getName());
    }
}
