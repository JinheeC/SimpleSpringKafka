package eda.fds.kafka.consumer;

import eda.fds.log.dto.LogDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class LogConsumer {
    private static final String ORDER_LOG = "orderLog";
    private static final String ORDER_START = "orderStart";
    private static final String ORDER_FINISH = "orderFinish";

//    @KafkaListener(topics = ORDER_LOG, id = "group1")
//    public void listen(LogDto message) {
//        System.out.println("Thread ID: " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
//        System.out.println("group1:: Log FDS 에서 메시지를 받았습니다: " + message.toString());
//    }
//
//    @KafkaListener(topics = ORDER_LOG, id = "group2")
//    public void listen1(LogDto message) {
//        System.out.println("Thread ID: " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
//        System.out.println("group2:: Log FDS 에서 메시지를 받았습니다: " + message.toString());
//    }

    @KafkaListener(topics = ORDER_LOG)
    public void listen2(@Payload LogDto message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition) {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
        System.out.println("partitionID: " + partition + " " + message);
    }

//    @KafkaListener(topicPartitions = @TopicPartition(topic = ORDER_LOG,
//                                                     partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "0")), groupId = "group3")

//    @KafkaListener(topics = ORDER_LOG, id = "group3")
//    public void listen3(@Payload LogDto message, @Header(KafkaHeaders.OFFSET) Integer offset) {
//        System.out.println("Thread ID: " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
//        System.out.println("@@@@@ " + message + "** at offset: " + offset);
//    }

    @KafkaListener(topics = ORDER_START)
    public void listenStart(LogDto message) {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
        System.out.println("주문 시작: "+ message);
    }

    @KafkaListener(topics = ORDER_FINISH)
    public void listenFinish(LogDto message) {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
        System.out.println("주문 완료: "+ message);
    }

//    @KafkaListener(topics = ORDER_FINISH)
//    public void listenFini(LogDto message) {
//        System.out.println("Thread ID: " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
//        System.out.println("주문 완료: "+ message);
//    }
}
