package com.graphql.spring.mappers;


import com.graphql.spring.domain.Product;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source ="store_id", target = "store_id"),
            @Mapping(source ="store", target = "store", ignore = true)
    })
    Product productToProductApi(com.graphql.spring.jpa.Product product);
    List<Product> productsToProductsApi(List<com.graphql.spring.jpa.Product> product);
}
