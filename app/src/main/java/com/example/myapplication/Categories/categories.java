package com.example.myapplication.Categories;

public class categories {
    private String name;

    public categories(String name) {
        this.name=name;
    }

    public static final com.example.myapplication.Categories.categories[] categories= {
            new categories("Scarf"),
            new categories("Bag"),
            new categories("Mini Bag"),
            new categories("Quilt"),
};

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name ;
    }
}
