package com.tarnet.managers;

import com.tarnet.interfaces.IEntity;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class EntityManager<T extends IEntity> { // TEMPLATE CLASS && TEMPLATE FUNCTIONS
    private List<T> dataList;

    public EntityManager(List<T> dataList) {
        this.dataList = dataList;
    }

    public Supplier<List<T>> findAll = () -> this.dataList;

    public Function<Integer, List<T>> findById = (Integer id) -> dataList.parallelStream().filter(e -> e.getId() == id).collect(Collectors.toList());

    public Function<String, List<T>> findByKeyword = (String keyword) -> dataList.parallelStream().filter(e -> e.toString().contains(keyword)).collect(Collectors.toList());
}
