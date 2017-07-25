package com.graphql.spring.graphql;

import com.graphql.spring.data.Info;
import com.graphql.spring.jpa.Product;
import com.graphql.spring.jpa.Store;
import com.graphql.spring.jpa.repositories.ProductRepository;
import com.graphql.spring.jpa.repositories.StoreRepository;
import graphql.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class Query {
    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;

    public Query(ProductRepository productRepository, StoreRepository storeRepository) {
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
    }

    @GraphQLField
    public List<Product> products(@GraphQLName("id") Integer id) {
        if(id != null) {
            return Collections.singletonList(productRepository.findOne(id));
        }else {
            return productRepository.findAll();
        }
    }

    @GraphQLField
    public List<Store> stores() {
        return storeRepository.findAll();
    }

    @GraphQLField
    @GraphQLDescription("server stats")
    public Info info() {
        return new Info();
    }
}


