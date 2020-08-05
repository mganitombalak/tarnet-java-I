package com.tarnet.enums;

public enum InventoryItemType {
    Stationery("Stationary Items"),
    OfficeElectronics("Small Office Electronics"),
    Electronics ("Big Office Electronics");

    private String desc;
    InventoryItemType(String description) {
        this.desc = description;
    }
    public String getDesc() {
        return desc;
    }
}
