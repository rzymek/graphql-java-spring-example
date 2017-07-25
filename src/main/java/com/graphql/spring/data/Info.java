package com.graphql.spring.data;

import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLName;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    public static class Pair {
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
}
