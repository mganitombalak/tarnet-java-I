package com.tarnet.managers;

import com.tarnet.interfaces.IEntity;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class EntityManager<T extends IEntity> { // TEMPLATE CLASS && TEMPLATE FUNCTIONS
    private List<T> dataList;

    public EntityManager(List<T> dataList) {
        this.dataList = dataList;
    }

    public Supplier<List<T>> findAll = () -> this.dataList;

    public List<T> findById(int id) {
        return dataList.parallelStream().filter(e -> e.getId() == id).collect(Collectors.toList());
    }

    public List<T> findByKeyword(String keyword) {
        return dataList.parallelStream().filter(e -> e.toString().contains(keyword)).collect(Collectors.toList());
    }
}
