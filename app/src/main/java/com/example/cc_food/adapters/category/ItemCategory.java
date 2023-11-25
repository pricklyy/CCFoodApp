package com.example.cc_food.adapters.category;

public class ItemCategory {
    private int id;
    private String img;
    private String name;

    public ItemCategory(int id, String img, String name) {
        this.id = id;
        this.img = img;
        this.name = name;
    }

    public ItemCategory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
