package com.graphql.spring.bl;

import com.graphql.spring.domain.Store;
import com.graphql.spring.jpa.StoreRepository;
import com.graphql.spring.mappers.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StoreRetriever {
    @Autowired
    StoreRepository storeRepository;


    StoreMapper storeMapper;

    public List<Store> getStores() {
        List<com.graphql.spring.jpa.Store> all = storeRepository.findAll();
        List<Store> stores = storeMapper.storesToStoresApi(all);
        return stores;
    }

    public Store getStore(int storeId) {
        com.graphql.spring.jpa.Store all = storeRepository.findByid(storeId);
        Store store = storeMapper.storeToStoreApi(all);
        return store;
    }
}
