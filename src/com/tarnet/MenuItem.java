package com.tarnet;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MenuItem<T> {
    // private,default,protected,public ACCESS MODIFIER
    private int id;
    private String title;
    private int displayOrder; //Instance Variable
    private int parentId;
    private Supplier<T> action;
    private Function<String, List<T>> stringParamAction;

    public MenuItem() {
    }

    public MenuItem(int id, String title, int displayOrder, int parentId, Supplier<T> action, Function<String, List<T>> stringParamAction) {
        this.id = id;
        this.title = title;
        this.displayOrder = displayOrder;
        this.parentId = parentId;
        this.action = action;
        this.stringParamAction = stringParamAction;
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

    public Supplier<T> getAction() {
        return action;
    }

    private void setAction(Supplier<T> action) {
        this.action = action;
    }

    public Function<String, List<T>> getStringParamAction() {
        return stringParamAction;
    }

    private void setStringParamAction(Function<String, List<T>> stringParamAction) {
        this.stringParamAction = stringParamAction;
    }


    // Builder Pattern
    public static class Builder<T> {
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

        public Builder withAction(Supplier<T> action){
            this.instance.setAction(action);
            return this;
        }

        public Builder withStringParamAction(Function<String,List<T>> action){
            this.instance.setStringParamAction(action);
            return this;
        }

        public MenuItem build() {
            return this.instance;
        }
    }
}
