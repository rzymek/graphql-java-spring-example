package com.graphql.spring.jpa;

import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLName;
import graphql.annotations.GraphQLType;

import javax.persistence.*;

@Entity
@GraphQLName("Product")
public class Product {
    private int id;
    private Store store;
    private String name;
    private double price;

    @GraphQLField
    @ManyToOne(fetch = FetchType.LAZY)
    public Store getStore() {
        return store;
    }

    @GraphQLField
    @Id @GeneratedValue
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