package com.graphql.spring.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.graphql.spring.jpa", "com.graphql.spring.mappers"})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com/graphql/spring/jpa", "com/graphql/spring/mappers"})
public class RepositoryConfig {
}
