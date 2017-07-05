package com.graphql.spring.jpa;

import graphql.annotations.GraphQLField;

import javax.persistence.*;

@Entity
public class Product {
    private int id;
    private Store store;
    private String name;
    private double price;

    @Access(AccessType.PROPERTY)
    @GraphQLField
    @ManyToOne(fetch = FetchType.LAZY)
    public Store getStore() {
        return store;
    }

    @Id
    @GraphQLField
    public int getId() {
        return id;
    }

    @GraphQLField
    public String getName() {
        return name;
    }

    @GraphQLField
    public double getPrice() {
        return price;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStore(Store store) {
        this.store = store;
    }

}