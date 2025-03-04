# NQL to SQL Query Service

This Spring Boot application enables users to query a SQL database using natural language. It integrates **LangChain4j** with **Ollama** to convert Natural Query Language (NQL) into SQL queries, which are executed on an in-memory H2 database initialized with the Chinook schema.

## Prerequisites
- Java 17+
- Maven
- Ollama installed and running locally

## Setup Instructions

1. **Install Ollama**:
    - Download and install Ollama from [ollama.com](https://ollama.com/).
    - Pull the deepseek model:
      ```bash
      ollama pull deepseek-r1
      

Postman Collection: [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/1f

Request API: http://localhost:8080/api/query
Request Body:
```json
{
    "nql": "Retrieve the names of all suppliers from the supplier_relationships table."
}
```
Response
Error executing query: StatementCallback; SQL [<think>
Okay, so I need to figure out how to write an SQL query based on this user's request. Let me start by understanding what they're asking for.

The user provided a bunch of database schemas, and their natural language query is: "Retrieve the names of all suppliers from the supplier_relationships table." They also want only the SQL query without any explanation.

Looking at the schema, the supplier_relationships table has an id (INT), supplier_id (INT), supplier_name (VARCHAR), contract_terms (TEXT), performance_rating (DECIMAL), is_approved (BIT), and primary_contact (VARCHAR). So each row represents a supplier relationship with details about the supplier's name, among other things.

The user wants to retrieve all supplier names. That means I need to select the supplier_name column from this table. The query should be straightforward: SELECT supplier_name FROM supplier_relationships.

I don't see any need for joining tables here because they only specified retrieving from supplier_relationships. There's no WHERE clause mentioned, so by default, it should return all records.

Wait, let me double-check the schema to make sure I'm selecting the correct column. Yes, supplier_name is present in the table. So the SQL query should just be SELECT supplier_name FROM supplier_relationships;

I don't think there are any constraints or additional fields needed here because the user didn't specify any conditions. They just want all the names.

So putting it all together, the SQL statement would be selecting the supplier_name column from the supplier_relationships table.
</think>

```sql
SELECT supplier_name FROM supplier_relationships;
```]; Statement.executeQuery() cannot issue statements that do not produce result sets.