package eda.coordinator.config;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import eda.coordinator.log.model.Log;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerConfig {
    private static final String BOOTSTRAP_ADDR = "localhost:9092";

    @Bean
    public ProducerFactory<String, Log> producerFactory() {
        Map<String, Object> producerConfig = new HashMap<>();

        producerConfig.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_ADDR);

        producerConfig.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerConfig.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, LogSerializer.class);

        return new DefaultKafkaProducerFactory<>(producerConfig);
    }

    @Bean
    public KafkaTemplate<String, Log> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
