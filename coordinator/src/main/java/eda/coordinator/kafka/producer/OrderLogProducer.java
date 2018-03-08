package eda.coordinator.kafka.producer;

import org.apache.avro.generic.GenericData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderLogProducer {
    private static final String ORDER ="order";

    @Autowired
    private KafkaTemplate<String, GenericData.Record> avroKafkaTemplate;

    public void sendAsAvro(GenericData.Record payloadAvro) {
        System.out.println("아브로 전송" + payloadAvro);
        avroKafkaTemplate.send(ORDER, payloadAvro);
    }
}
