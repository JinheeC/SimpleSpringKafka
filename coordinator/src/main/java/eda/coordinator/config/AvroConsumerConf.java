package eda.coordinator.config;

import eda.coordinator.log.dto.Payload;
import org.apache.avro.generic.GenericData;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class AvroConsumerConf {
    private static final String GROUP_ID = "1";
    private static final String BOOTSTRAP_ADDR = "localhost:9092";

    @Bean
    public ConsumerFactory<String, GenericData.Record> consumerFactory() {
        Map<String, Object> consumerConfig = new HashMap<>();

        consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_ADDR);
        consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);

        consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, AvroDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(consumerConfig, new StringDeserializer(), new AvroDeserializer(Payload.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, GenericData.Record> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, GenericData.Record> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
