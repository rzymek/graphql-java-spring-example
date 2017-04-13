package com.graphql.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@ComponentScan(basePackages = {"com.graphql.spring.graphql", "com.graphql.spring.bl", "com.graphql.spring.domain", "com.graphql.spring.mappers"})
public class AppConfig {
}
