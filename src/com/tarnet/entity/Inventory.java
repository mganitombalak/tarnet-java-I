package com.tarnet.entity;

import com.tarnet.enums.InventoryItemType;
import com.tarnet.interfaces.IEntity;

public class Inventory implements IEntity {
    private int id;
    private String name;
    private InventoryItemType itemType;

    public Inventory() { }

    public Inventory(int id, String name, InventoryItemType itemType) {
        this.id = id;
        this.name = name;
        this.itemType = itemType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InventoryItemType getItemType() {
        return itemType;
    }

    public void setItemType(InventoryItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itemType=" + itemType +
                '}';
    }
}
