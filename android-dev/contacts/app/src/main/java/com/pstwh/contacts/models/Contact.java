package com.pstwh.contacts.models;

import java.io.Serializable;

/**
 * Created by pstwh on 27/02/2018.
 */

public class Contact implements Serializable {
    private Long id;
    private String name;
    private String address;
    private String telephone;
    private String website;
    private Double rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double ratting) {
        this.rating = ratting;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
