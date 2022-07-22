package dev.fullstackcode.eis;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.containers.OracleContainer;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Testcontainers
@DirtiesContext
public  class BaseIT {

    @Autowired
    protected TestRestTemplate testRestTemplate ;

//    @Container
//    public static OracleContainer oracleDB = new OracleContainer("gvenzl/oracle-xe:21-slim");


    // Note : either use @Container annotation to start or use following  code block to start the container
    public static OracleContainer oracleDB;

    static {
         oracleDB = new OracleContainer("gvenzl/oracle-xe:21-slim");
         oracleDB.start();
    }


    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url",oracleDB::getJdbcUrl);
        registry.add("spring.datasource.username", oracleDB::getUsername);
        registry.add("spring.datasource.password", oracleDB::getPassword);

    }

}