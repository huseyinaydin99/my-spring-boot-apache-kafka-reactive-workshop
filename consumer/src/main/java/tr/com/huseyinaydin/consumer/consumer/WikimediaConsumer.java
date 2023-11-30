package tr.com.huseyinaydin.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, Apache Kafka.
 *
 */

@Service
@Slf4j
public class WikimediaConsumer {

    @KafkaListener(topics = "topic1", groupId = "grup1")
    public void consumeMsg(String msg) {
        log.info(format("String mesaj topic1'den tüketildi.", msg));
    }
}