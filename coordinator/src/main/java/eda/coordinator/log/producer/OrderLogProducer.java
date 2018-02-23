package eda.coordinator.log.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import eda.coordinator.log.model.Log;

@Service
public class OrderLogProducer {
    private static final String ORDER_TOPIC ="orderLog";

    @Autowired
    private KafkaTemplate<String, Log> kafkaTemplate;

    public void sendMessage(Log message) {
        kafkaTemplate.send(ORDER_TOPIC, message);
    }
}
