package ru.artamonov.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
//@ComponentScan(basePackages = {
//        "ru.artamonov.producer.config",
//        "ru.artamonov.producer.controller",
//        "ru.artamonov.producer.service",
//        "ru.artamonov.producer.kafka.enums"
//})
@PropertySource({
        "classpath:kafka.properties"
})
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }
}
