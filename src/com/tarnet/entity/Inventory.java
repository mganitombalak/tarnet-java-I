package com.tarnet.entity;

import com.tarnet.enums.InventoryItemType;

public class Inventory {
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
}
