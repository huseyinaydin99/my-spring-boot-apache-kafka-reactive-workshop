package tr.com.huseyinaydin.kafka.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, Apache Kafka.
 *
 */

@Getter
@Setter
@ToString
public class Student {

    private int id;
    private String firstname;
    private String lastname;
}