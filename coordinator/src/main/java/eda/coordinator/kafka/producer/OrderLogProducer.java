package eda.coordinator.kafka.producer;

import org.apache.avro.generic.GenericData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderLogProducer {
    private static final String ORDER_LOG ="orderLog";
    private static final String ORDER_START ="orderStart";
    private static final String ORDER_FINISH ="orderFinish";
    private static final String ORDER ="order";
//
//    @Autowired
//    private KafkaTemplate<String, LogDto> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, GenericData.Record> avroKafkaTemplate;
//
//    public void sendMessage(LogDto message) {
//        kafkaTemplate.send(ORDER_LOG, message);
//    }
//
//    public void sendOrderStart(LogDto message) {
//        kafkaTemplate.send(ORDER_START, message);
//    }
//
//    public void sendOrderFinish(LogDto message) {
//        kafkaTemplate.send(ORDER_FINISH, message);
//    }

    public void sendAsAvro(GenericData.Record payloadAvro) {
        System.out.println("아브로 전송" + payloadAvro);
        avroKafkaTemplate.send(ORDER, payloadAvro);
    }
}
