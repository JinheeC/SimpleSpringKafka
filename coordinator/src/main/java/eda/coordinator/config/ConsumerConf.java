package eda.coordinator.config;

import eda.coordinator.log.dto.LogDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

import java.util.HashMap;
import java.util.Map;

//@EnableKafka
//@Configuration
//public class ConsumerConf {
//    private static final String GROUP_ID = "1";
//    private static final String BOOTSTRAP_ADDR = "localhost:9092";
//
//    @Bean
//    public ConsumerFactory<String, LogDto> consumerFactory() {
//        Map<String, Object> consumerConfig = new HashMap<>();
//
//        consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_ADDR);
//        consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
//
//        consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, LogDeserializer.class);
//        consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringJsonMessageConverter.class);
//
//        return new DefaultKafkaConsumerFactory<>(consumerConfig, new StringDeserializer(), new LogDeserializer());
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, LogDto> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, LogDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
//}
