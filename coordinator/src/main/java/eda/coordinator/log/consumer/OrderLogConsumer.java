package eda.coordinator.log.consumer;

import eda.coordinator.log.model.Log;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderLogConsumer {

    @KafkaListener(topics = "orderLog")
    public void listen(Log message) {
        System.out.println("orderLog 토픽에 대한 메시지를 받았습니다: "+  message.toString());
    }
}