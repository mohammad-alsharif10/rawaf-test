package com.ingestion.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author mohammad
 */
@Configuration
public class BeanConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public NewTopic city1() {
        return TopicBuilder.name("city1")
                .partitions(6)
                .replicas(3)
                .build();
    }

    @Bean(name = "city2")
    public NewTopic city2() {
        return TopicBuilder.name("city2")
                .partitions(6)
                .replicas(3)
                .build();
    }

    @Bean(name = "city3")
    public NewTopic city3() {
        return TopicBuilder.name("city3")
                .partitions(6)
                .replicas(3)
                .build();
    }

    @Bean(name = "city4")
    public NewTopic city4() {
        return TopicBuilder.name("city4")
                .partitions(6)
                .replicas(3)
                .build();
    }

    @Bean(name = "city5")
    public NewTopic city5() {
        return TopicBuilder.name("city5")
                .partitions(6)
                .replicas(3)
                .build();
    }

    @Bean(name = "city6")
    public NewTopic city6() {
        return TopicBuilder.name("city6")
                .partitions(6)
                .replicas(3)
                .build();
    }

    @Bean(name = "city7")
    public NewTopic city7() {
        return TopicBuilder.name("city7")
                .partitions(6)
                .replicas(3)
                .build();
    }

    @Bean(name = "city8")
    public NewTopic city8() {
        return TopicBuilder.name("city8")
                .partitions(6)
                .replicas(3)
                .build();
    }

    @Bean(name = "city9")
    public NewTopic city9() {
        return TopicBuilder.name("city9")
                .partitions(6)
                .replicas(3)
                .build();
    }

    @Bean(name = "city10")
    public NewTopic city10() {
        return TopicBuilder.name("city10")
                .partitions(6)
                .replicas(3)
                .build();
    }
}
