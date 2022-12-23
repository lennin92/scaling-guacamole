package com.ingeneo.scalingguacamole;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;

@SpringBootTest
@MockBeans({
        @MockBean(name = "liquibase", classes = LiquibaseAutoConfiguration.LiquibaseConfiguration.class)
})
class ScalingGuacamoleApplicationTests {

    @Test
    void contextLoads() {
    }

}
