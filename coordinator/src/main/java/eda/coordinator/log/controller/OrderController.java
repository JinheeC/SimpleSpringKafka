package eda.coordinator.log.controller;

import eda.coordinator.log.dto.LogDto;
import eda.coordinator.log.dto.Payload;
import eda.coordinator.log.entity.Log;
import eda.coordinator.kafka.producer.OrderLogProducer;
import eda.coordinator.log.entity.ReasonType;
import eda.coordinator.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderLogProducer orderLogProducer;

    @Autowired
    private LogService logService;

    @GetMapping(value = "/log/{orderId}")
    public void orderLog(@PathVariable Long orderId, @RequestParam Boolean isStart) {
        LogDto message = new LogDto(orderId, isStart);
        logService.create(message);
//        orderLogProducer.sendMessage(message);
    }

    @GetMapping(value = "/start/{orderId}")
    public void completeOrder(@PathVariable Long orderId, @RequestParam Boolean isStart) {
        LogDto message = new LogDto(orderId, isStart);
        logService.create(message);
//        orderLogProducer.sendOrderStart(message);
    }

    @GetMapping(value = "/finish/{orderId}")
    public void cancelOrder(@PathVariable Long orderId, @RequestParam Integer reason) {
        LogDto message = new LogDto(orderId, ReasonType.valueOf(reason));
        logService.create(message);
//        orderLogProducer.sendOrderFinish(message);
    }

    @GetMapping(value = "/{orderNo}")
    public void orderWithAvro(@PathVariable Long orderNo) {
        Payload payload = new Payload(orderNo);
        orderLogProducer.sendAsAvro(payload.converToAvro());
    }
}
