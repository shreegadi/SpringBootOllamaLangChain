package com.bytewizard.ollama_langchain.controller;

import com.bytewizard.ollama_langchain.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class QueryController {

    @Autowired
    private QueryService queryService;

    @PostMapping("/query")
    public Object query(@RequestBody Map<String, String> request) {
        String query = request.get("query");
        return queryService.processQuery(query);
    }
}