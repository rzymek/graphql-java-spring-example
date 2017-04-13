package com.graphql.spring.mappers;


import com.graphql.spring.domain.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface StoreMapper {
    @Mappings({
            @Mapping(source = "id", target = "id")
    })
    Store storeToStoreApi(com.graphql.spring.jpa.Store car);
    List<Store> storesToStoresApi(List<com.graphql.spring.jpa.Store> car);
}
