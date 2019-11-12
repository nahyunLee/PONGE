package com.leenahyun.computer.pblfirebase;

public class Item {

    private String price;
    private String size;
    private String description;
    private String color;
    private String image;

    public Item() {
        this.price = price;
        this.size = size;
        this.description = description;
        this.color = color;
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}