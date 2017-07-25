package com.graphql.spring.graphql;

import graphql.ExecutionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class GraphQLController {
    private static final Logger log = LoggerFactory.getLogger(GraphQLController.class);

    @Autowired
    private GraphQLExecutor executor;

    @RequestMapping(value = "/graphql", method = RequestMethod.POST)
    public Map<String, Object> graphql(@RequestBody Map<String, Object> request) {
        String query = (String) request.get("query");
        String operationName = (String) request.get("operationName");
        Map<String, Object> variables = (Map<String, Object>)
                Optional.ofNullable(request.get("variables")).orElse(Collections.emptyMap());

        ExecutionResult executionResult = executor.execute(query, operationName, variables);

        Map<String, Object> result = new LinkedHashMap<>();
        if (!executionResult.getErrors().isEmpty()) {
            log.error("Errors: {}", executionResult.getErrors());
            result.put("errors", executionResult.getErrors());
        }
        result.put("data", executionResult.getData());
        return result;
    }
}
