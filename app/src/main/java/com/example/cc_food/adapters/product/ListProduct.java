package com.example.cc_food.adapters.product;


import com.example.cc_food.adapters.item_product.ItemProduct;

import java.util.ArrayList;

public class ListProduct {
    private String nameProduct;
    private ArrayList<ItemProduct> list;

    public ListProduct(String nameProduct, ArrayList<ItemProduct> list) {
        this.nameProduct = nameProduct;
        this.list = list;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public ArrayList<ItemProduct> getList() {
        return list;
    }

    public void setList(ArrayList<ItemProduct> list) {
        this.list = list;
    }
}
