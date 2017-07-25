package com.graphql.spring.data;

import graphql.annotations.GraphQLField;

import java.time.LocalDateTime;

public class TimeFormat {
    private final LocalDateTime time;

    public TimeFormat(LocalDateTime time) {
        this.time = time;
    }

    @GraphQLField
    public String getDate() {
        return time.toLocalDate().toString();
    }
    @GraphQLField
    public String getTime() {
        return time.toLocalTime().toString();
    }
}
