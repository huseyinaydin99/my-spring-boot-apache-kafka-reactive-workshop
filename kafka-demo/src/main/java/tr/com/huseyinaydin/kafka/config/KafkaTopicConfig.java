package tr.com.huseyinaydin.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, Apache Kafka.
 *
 */

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic alibouTopic() {
        return TopicBuilder
                .name("topic1")
                .build();
    }
}
