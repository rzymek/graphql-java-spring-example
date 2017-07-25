package com.graphql.spring.data;

import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLName;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Info {
    @GraphQLField
    public String serverTime() {
        return LocalDateTime.now().toString();
    }

    @GraphQLField
    public List<Pair> props(@GraphQLName("key") String key) {
        return System.getProperties()
                .entrySet()
                .stream()
                .filter(e -> key == null ? true : e.getKey().toString().contains(key))
                .map(Pair::new)
                .collect(toList());
    }

}
