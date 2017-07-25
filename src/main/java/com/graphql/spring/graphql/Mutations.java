package com.graphql.spring.graphql;

import com.graphql.spring.data.Info;
import com.graphql.spring.jpa.Product;
import com.graphql.spring.jpa.repositories.ProductRepository;
import com.graphql.spring.jpa.repositories.StoreRepository;
import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLName;
import org.springframework.stereotype.Component;

@Component
public class Mutations {

    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;

    public Mutations(ProductRepository productRepository, StoreRepository storeRepository) {
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
    }

    @GraphQLField
    public Info.Pair setProperty(@GraphQLName("key") String key, @GraphQLName("value") String value) {
        System.setProperty(key, value);
        return new Info.Pair(key, value);
    }

    @GraphQLField
    public Product addProduct(@GraphQLName("input") ProductInput input) {
        Product product = new Product();
        product.setName(input.name);
        product.setStore(storeRepository.findOne(input.storeId));
        product.setPrice(input.price);
        return productRepository.save(product);
    }
}
