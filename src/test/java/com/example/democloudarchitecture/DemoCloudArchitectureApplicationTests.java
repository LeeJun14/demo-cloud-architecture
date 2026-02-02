package com.example.democloudarchitecture;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestPropertySource(properties = {
        "spring.cloud.aws.parameterstore.enabled=false",
        "spring.cloud.aws.s3.enabled=false",
        "spring.cloud.aws.region.static=ap-northeast-2",
        "spring.datasource.url=jdbc:h2:mem:testdb",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.jpa.hibernate.ddl-auto=create-drop",
        "spring.autoconfigure.exclude=io.awspring.cloud.autoconfigure.s3.S3AutoConfiguration,io.awspring.cloud.autoconfigure.core.AwsAutoConfiguration"
})
class DemoCloudArchitectureApplicationTests {

    @Test
    void contextLoads() {
    }
}
