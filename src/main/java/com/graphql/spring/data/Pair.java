package com.graphql.spring.data;

import graphql.annotations.GraphQLField;

import java.util.Map;
import java.util.Objects;

public class Pair {
    @GraphQLField
    public String key;
    @GraphQLField
    public String value;

    public Pair(Map.Entry<Object, Object> entry) {
        key = entry.getKey().toString();
        value = Objects.toString(entry.getValue());
    }

    public Pair(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
