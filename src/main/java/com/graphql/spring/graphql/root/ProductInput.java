package com.graphql.spring.graphql.root;

import graphql.annotations.GraphQLField;

import java.util.HashMap;

public class ProductInput {
    @GraphQLField
    public final String name;
    @GraphQLField
    public final int storeId;
    @GraphQLField
    public final double price;

    public ProductInput(HashMap<String, Object> values) {
        this.name = (String) values.get("name");
        this.storeId = (int) values.get("storeId");
        this.price = (double) values.get("price");
    }
}
