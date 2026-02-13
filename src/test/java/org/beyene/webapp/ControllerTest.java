package org.beyene.webapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {

    private static final String PATH = "/api/v1";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetHello() {
        String name = "John Doe";
        String body = this.restTemplate.getForObject(PATH + "/hello?name=" + name, String.class);
        assertThat(body).isEqualTo(String.format("Hello %s!", name));
    }

    @Test
    public void testGetTest() {
        String body = this.restTemplate.getForObject(PATH + "/test?name=throw", String.class);
        assertThat(body).isEqualTo("THROW is not a valid argument!");
    }

}
