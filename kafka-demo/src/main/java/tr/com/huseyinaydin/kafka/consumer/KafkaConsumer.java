package tr.com.huseyinaydin.kafka.consumer;

import tr.com.huseyinaydin.kafka.payload.Student;
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
public class KafkaConsumer {

    // @KafkaListener(topics = "alibou", groupId = "myGroup")
    public void consumeMsg(String msg) {
        log.info(format("String formatında mesaj topic1'den tüketildi.", msg));
    }

    @KafkaListener(topics = "topic1", groupId = "grup1")
    public void consumeJsonMsg(Student student) {
        log.info(format("Öğrenci kaydına ait JSON mesajı tüketildi.", student.toString()));
    }
}