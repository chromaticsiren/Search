Rest based WebService project which will do the following

1. Index the data using lucene which is sent in the webservice request
    Data has to be sent as a JSON string.
    The JSON string is then Deserialized to List and then indexed.
    
2. For querying, jsp is used as input interface (this is not completely built, W.I.P)

3. Built on Lucene 7.4.x, Java 8 and Tomcat 8.5.32 and Jacksom 2.9.x for JSON operations

4. Web service client is not part of this project.
