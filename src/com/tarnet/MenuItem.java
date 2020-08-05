package com.tarnet;

public class MenuItem {
    // private,default,protected,public ACCESS MODIFIER
    private int id;
    private String title;
    private int displayOrder; //Instance Variable
    private int parentId;

    public MenuItem() {
    }

    public MenuItem(String title, int displayOrder) {
        //            argument
        this.setTitle(title);
        this.setDisplayOrder(displayOrder);
    }

    // PROPERTY ENCAPSULATION / GETTER-SETTER ENCAPSULATION
    public String getTitle() {
        return title;
    }

    //                           Parameter
    private void setTitle(String title) {
        // DERIVED CLASS CAN CONTAIN LOGIC
        this.title = title;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    private void setDisplayOrder(int displayOrder) {
        // EXTRA BUSINESS LOGIC
        this.displayOrder = displayOrder;
    }

    @Override
    public String toString() {
        return this.getDisplayOrder() + "." +this.getTitle() + "("+this.getId()+")";
//                "MenuItem{" +
//                "title='" + title + '\'' +
//                ", displayOrder=" + displayOrder +
//                ", parent=" + parent +
//                '}';
    }

    public int getParentId() {
        return parentId;
    }

    private void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    // Builder Pattern
    public static class Builder {
        private MenuItem instance;

        public Builder() {
            this.instance = new MenuItem();
        }

        public Builder withId(int id){
            this.instance.setId(id);
            return this;
        }
        public Builder withTitle(String title) {
            this.instance.setTitle(title);
            return this;
        }

        public Builder withDisplayOrder(int order) {
            this.instance.setDisplayOrder(order);
            return this;
        }

        public Builder withParentId(int id){
            this.instance.setParentId(id);
            return this;
        }

        public MenuItem build() {
            return this.instance;
        }
    }
}
