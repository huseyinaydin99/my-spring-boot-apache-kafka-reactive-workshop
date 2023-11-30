package tr.com.huseyinaydin.kafka.rest;

import tr.com.huseyinaydin.kafka.payload.Student;
import tr.com.huseyinaydin.kafka.producer.KafkaJsonProducer;
import tr.com.huseyinaydin.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Spring Boot, Apache Kafka.
 * @since 1994
 */

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer; //String gönderici.
    private final KafkaJsonProducer kafkaJsonProducer; //JSON gönderici.

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("String mesajı Apache Kafka kuyruğuna gönderildi!");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student message) {
        kafkaJsonProducer.sendMessage(message);
        return ResponseEntity.ok("JSON mesajı Apache Kafka kuyruğuna gönderildi!");
    }
}