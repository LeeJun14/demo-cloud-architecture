package com.example.democloudarchitecture;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
        "spring.cloud.aws.parameterstore.enabled=false",
        "spring.cloud.aws.s3.enabled=false"
})
class DemoCloudArchitectureApplicationTests {
    @Test
    void contextLoads() {
    }
}
