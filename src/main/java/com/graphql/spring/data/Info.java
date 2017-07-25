package com.graphql.spring.data;

import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLName;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @GraphQLField
    public List<String> listDir(@GraphQLName("dir") String dir) throws IOException {
        Path path = Paths.get(dir == null ? "." : dir);
        return Files.list(path)
                .map(Path::toString)
                .collect(toList());
    }

}
