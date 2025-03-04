package com.bytewizard.ollama_langchain.service;

import com.bytewizard.ollama_langchain.db.DatabaseSchemaProvider;
import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QueryService {

    @Autowired
    private ChatLanguageModel chatLanguageModel;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DatabaseSchemaProvider schemaProvider;

    public Object processQuery(String naturalLanguageQuery) {
        String schema = schemaProvider.getDatabaseSchema();
        String prompt = "You are an assistant that converts natural language queries into SQL queries.\n" +
                "Here is the database schema:\n" + schema + "\n" +
                "Given the following natural language query, generate the corresponding SQL query:\n" +
                naturalLanguageQuery + "\n" +
                "Please provide only the SQL query without any explanation.";

        String sqlQuery = chatLanguageModel.generate(prompt);

        try {
            List<Map<String, Object>> result = jdbcTemplate.queryForList(sqlQuery);
            return result;
        } catch (Exception e) {
            return "Error executing query: " + e.getMessage();
        }
    }
}