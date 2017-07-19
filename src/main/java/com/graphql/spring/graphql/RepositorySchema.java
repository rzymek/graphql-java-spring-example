package com.graphql.spring.graphql;

import graphql.GraphQL;
import graphql.annotations.GraphQLAnnotations;
import graphql.schema.GraphQLObjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

import static graphql.schema.GraphQLSchema.newSchema;

@Component
public class RepositorySchema {

    private Query query;

    private GraphQL graphQL;

    @Autowired
    public RepositorySchema(Query query) throws IllegalAccessException, NoSuchMethodException, InstantiationException {
        this.query = query;
        this.graphQL = createGraphQLSchema();
    }

    public Object execute(String queryString) {
        if (!isIntrospectionQuery(queryString)) {
            return graphQL.execute(queryString, query).getData();
        } else {
            return Collections.singletonMap("data", graphQL.execute(queryString).getData());
        }
    }

    private GraphQL createGraphQLSchema() throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        GraphQLObjectType queryObject = GraphQLAnnotations.object(Query.class);
        return new GraphQL(newSchema().query(queryObject).build());
    }

    private static boolean isIntrospectionQuery(String queryString) {
        return queryString.contains("IntrospectionQuery");
    }
}
