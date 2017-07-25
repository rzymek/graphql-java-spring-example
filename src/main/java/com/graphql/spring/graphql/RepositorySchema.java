package com.graphql.spring.graphql;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.annotations.GraphQLAnnotations;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

@Component
public class RepositorySchema {

    private final Query queryRoot;
    private final GraphQL graphQL;
    private final Mutations mutationsRoot;

    @Autowired
    public RepositorySchema(Query query, Mutations mutations)
            throws IllegalAccessException, NoSuchMethodException, InstantiationException {
        this.queryRoot = query;
        this.mutationsRoot = mutations;
        this.graphQL = createGraphQLSchema();
    }

    public ExecutionResult execute(String query, String operationName, Map<String, Object> variables) {
        Object root = isMutation(query, operationName) ? mutationsRoot : queryRoot;
        return graphQL.execute(query, operationName, root, variables);
    }

    private GraphQL createGraphQLSchema() throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(GraphQLAnnotations.object(Query.class))
                .mutation(GraphQLAnnotations.object(Mutations.class))
                .build();
        return GraphQL.newGraphQL(schema)
                .build();
    }

    private boolean isMutation(String query, String operationName) {
        String name = Optional.ofNullable(operationName).orElse("");
        return Pattern.compile("mutation +" + Pattern.quote(name), Pattern.CASE_INSENSITIVE)
                .matcher(query)
                .find();
    }
}
