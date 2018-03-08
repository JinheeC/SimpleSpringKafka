package eda.coordinator.kafka.consumer;

import eda.coordinator.log.dto.LogDto;
import eda.coordinator.log.dto.Payload;
import org.apache.avro.generic.GenericData;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderLogConsumer {
//
//    @KafkaListener(topics = "orderLog")
//    public void listen(LogDto message) {
//        System.out.println("orderLog 토픽에 대한 메시지를 받았습니다: " + message.toString());
//    }
//
//    @KafkaListener(topics = "orderStart")
//    public void listenStart(LogDto message) {
//        System.out.println("주문이 시작되었습니다: " + message.toString());
//    }
//
//    @KafkaListener(topics = "orderFinish")
//    public void listenFinish(LogDto message) {
//        System.out.println("주문이 완료되었습니다: " + message.toString());
//    }

    @KafkaListener(topics = "order")
    public void listenAvro(Payload message) {
        System.out.println("아브로" + message);
    }
}