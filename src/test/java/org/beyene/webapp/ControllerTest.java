package org.beyene.webapp;

import org.beyene.webapp.dto.Time;
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

    @Test
    public void testGetTime() {
        Time time = this.restTemplate.getForObject(PATH + "/time", Time.class);
        assertThat(time).isNotNull();
        assertThat(time.hour).isNotNull().matches("\\d{2}");
        assertThat(time.minute).isNotNull().matches("\\d{2}");
        assertThat(time.second).isNotNull().matches("\\d{2}");
        
        // Verify the format is valid time (00-23 for hour, 00-59 for minute and second)
        int hour = Integer.parseInt(time.hour);
        int minute = Integer.parseInt(time.minute);
        int second = Integer.parseInt(time.second);
        
        assertThat(hour).isBetween(0, 23);
        assertThat(minute).isBetween(0, 59);
        assertThat(second).isBetween(0, 59);
    }

}
