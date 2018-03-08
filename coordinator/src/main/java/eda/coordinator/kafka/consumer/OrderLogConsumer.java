package eda.coordinator.kafka.consumer;

import eda.coordinator.log.dto.PayloadDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderLogConsumer {

    @KafkaListener(topics = "order")
    public void listenAvro(PayloadDto message) {
        System.out.println("아브로 " + message);
    }

}