package com.graphql.spring.graphql;

import com.graphql.spring.domain.Product;
import com.graphql.spring.domain.Store;
import com.graphql.spring.graphql.fetchers.StoreDataFetcher;
import graphql.annotations.GraphQLDataFetcher;
import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLName;
import com.graphql.spring.graphql.fetchers.ProductDataFetcher;
import com.graphql.spring.graphql.fetchers.ProductsDataFetcher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query {

    @GraphQLField
    @GraphQLDataFetcher(ProductDataFetcher.class)
    public Product product(@GraphQLName("product_id") int product_id) {
        return null;
    }

    @GraphQLField
    @GraphQLDataFetcher(StoreDataFetcher.class)
    public Store store(@GraphQLName("store_id") int store_id) {
        return null;
    }

    @GraphQLField
    @GraphQLDataFetcher(ProductsDataFetcher.class)
    public List<Product> products() { return null;}
}


