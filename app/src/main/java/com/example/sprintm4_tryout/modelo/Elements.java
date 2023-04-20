package com.example.sprintm4_tryout.modelo;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Elements {

    @PrimaryKey(autoGenerate = true)
    public long idElemento;
    public String image;
    public String destination;
    public String timeFor;
    public String price;

    public Elements() {
    }

    public Elements( long idElemento, String image, String destination, String timeFor, String price) {
        this.idElemento = idElemento;
        this.image = image;
        this.destination = destination;
        this.timeFor = timeFor;
        this.price = price;
    }

    public long getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(long idElemento) {
        this.idElemento = idElemento;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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

