package com.tarnet.thread;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Person {
    private int id;
    private String name;
    private String department;
    private double salary;

    public void print(){
        System.out.printf("id:%d - Name:%s%n",this.getId(),this.getName(),this.department,this.salary);
    }

    public String getName() {
        return name;
    }
    public String getId() {
        return name;
    }
}
