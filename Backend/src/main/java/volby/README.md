TO GET SWAGGER:

ADD THIS TO pom.xml

<dependency>
<groupId>org.springdoc</groupId>
<artifactId>springdoc-openapi-data-rest</artifactId>
<version>1.2.32</version>
</dependency>

<dependency>
<groupId>org.springdoc</groupId>
<artifactId>springdoc-openapi-ui</artifactId>
<version>1.2.32</version>
</dependency>

ADD THIS TO PROPERTIES
springdoc.swagger-ui.path=/swagger
springdoc.swagger-ui.operationsSorter=method
springdoc.api-docs.path=/api-docs

You can find swagger then by visiting: /swagger
