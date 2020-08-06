package com.tarnet;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;

@AllArgsConstructor
public class MenuItem<T> {
    // private,default,protected,public ACCESS MODIFIER
//    @Getter
//    @Setter(AccessLevel.PRIVATE)
    private int id;
    private String title;
    private int displayOrder; //Instance Variable
    private int parentId;
    private Supplier<T> action;
    private Function<String, List<T>> stringParamAction;
    private IntFunction<List<T>> idParamAction;

    public MenuItem() {
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    private void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public int getParentId() {
        return parentId;
    }

    private void setParentId(int parentId) {
        this.parentId = parentId;
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

    public IntFunction<List<T>> getIdParamAction() {
        return idParamAction;
    }

    private void setIdParamAction(IntFunction<List<T>> idParamAction) {
        this.idParamAction = idParamAction;
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

        public Builder withIdParamAction(IntFunction<List<T>> action){
            this.instance.setIdParamAction(action);
            return this;
        }

        public MenuItem build() {
            return this.instance;
        }
    }
}
