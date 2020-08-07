package com.tarnet.thread;

import java.util.List;

/**
 * Created by oyasar on 7.08.2020.
 */
public class Raise implements Runnable {

    private List<Person> list;

    public Raise(List<Person> list) {
        this.list = list;
    }

    @Override
    public void run() {
        this.list
                .forEach(x -> {
                    if(x.getDepartment() == "HR"){
                        x.setSalary((x.getSalary() * 0.05) + x.getSalary());
                    }else{
                        x.setSalary((x.getSalary() * 0.10) + x.getSalary());
                    }
                }
                );
    }
}
