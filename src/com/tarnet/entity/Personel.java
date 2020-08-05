package com.tarnet.entity;

import com.tarnet.interfaces.IEntity;

public class Personel implements IEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String title;
    private Department department;

    public Personel() { }

    public Personel(int id, String firstName, String lastName, String title, Department department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return this.firstName +" "+ this.lastName;
    }
}
