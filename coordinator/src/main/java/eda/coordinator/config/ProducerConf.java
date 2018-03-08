package eda.coordinator.config;

import eda.coordinator.log.dto.LogDto;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.internals.DefaultPartitioner;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

//@Configuration
//public class ProducerConf {
//    private static final String BOOTSTRAP_ADDR = "localhost:9092";
//
//    @Bean
//    public ProducerFactory<String, LogDto> producerFactory() {
//        Map<String, Object> producerConfig = new HashMap<>();
//
//        producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_ADDR);
//
//        producerConfig.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, DefaultPartitioner.class);
//        producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, LogSerializer.class);
//
//        return new DefaultKafkaProducerFactory<>(producerConfig);
//    }
//
//    @Bean
//    public KafkaTemplate<String, LogDto> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//}
