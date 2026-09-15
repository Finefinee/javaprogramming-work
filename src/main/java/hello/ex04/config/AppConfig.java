package hello.ex04.config;

import hello.ex04.computer.Computer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Computer computer() {
        return new Computer();
    }

}
