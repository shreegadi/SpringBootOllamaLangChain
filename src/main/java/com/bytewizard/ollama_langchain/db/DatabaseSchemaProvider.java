package com.bytewizard.ollama_langchain.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.*;

@Component
public class DatabaseSchemaProvider {

    @Autowired
    private DataSource dataSource;

    public String getDatabaseSchema() {
        StringBuilder schema = new StringBuilder();
        try (Connection conn = dataSource.getConnection()) {
            DatabaseMetaData metaData = conn.getMetaData();
            String[] types = {"TABLE"};
            ResultSet tables = metaData.getTables(null, null, "%", types);
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                schema.append("Table: ").append(tableName).append("\n");
                ResultSet columns = metaData.getColumns(null, null, tableName, "%");
                while (columns.next()) {
                    String columnName = columns.getString("COLUMN_NAME");
                    String columnType = columns.getString("TYPE_NAME");
                    schema.append("  ").append(columnName).append(" ").append(columnType).append("\n");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve database schema", e);
        }
        return schema.toString();
    }
}