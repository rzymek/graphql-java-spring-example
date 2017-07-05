package com.graphql.spring.graphql.fetchers;

import com.graphql.spring.bl.StoreRetriever;
import com.graphql.spring.domain.Store;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class StoreDataFetcher implements DataFetcher, ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public Object get(DataFetchingEnvironment environment) {
        StoreRetriever productRetriever = context.getBean(StoreRetriever.class);
        Integer storeId = environment.getArgument("storeId");
        if(storeId == null) {
            return null;
        }

        return productRetriever.getStore(storeId);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
