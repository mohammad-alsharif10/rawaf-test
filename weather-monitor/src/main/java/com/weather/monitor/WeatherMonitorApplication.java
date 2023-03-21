package com.weather.monitor;

import com.weather.monitor.entity.User;
import com.weather.monitor.model.RegisterRequest;
import com.weather.monitor.repository.UserRepository;
import com.weather.monitor.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

/**
 * @author mohammad
 */
@SpringBootApplication
@RequiredArgsConstructor
public class WeatherMonitorApplication {

    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(WeatherMonitorApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Optional<User> optionalUser = userRepository.findByEmail("test_4609cbdcc160");
            if (optionalUser.isEmpty()) {
                authenticationService.register(RegisterRequest.builder()
                        .email("test_4609cbdcc160")
                        .password("test_0d1b253cf339")
                        .build());
            }
        };
    }

}
