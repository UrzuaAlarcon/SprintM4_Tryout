package com.example.sprintm4_tryout;

public class Elements {

    public int image;
    public String destination;
    public String timeFor;
    public String price;

    public Elements(int image, String destination, String timeFor, String price) {
        this.image = image;
        this.destination = destination;
        this.timeFor = timeFor;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTimeFor() {
        return timeFor;
    }

    public void setTimeFor(String timeFor) {
        this.timeFor = timeFor;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
