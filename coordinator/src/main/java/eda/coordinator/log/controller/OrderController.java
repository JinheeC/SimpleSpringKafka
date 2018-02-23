package eda.coordinator.log.controller;

import eda.coordinator.log.model.Log;
import eda.coordinator.log.producer.OrderLogProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderLogProducer orderLogProducer;

    @GetMapping(value = "/produce/{id}")
    public void produceLog(@PathVariable Long id, @RequestParam Boolean isStart) {
        Log message = new Log(id, isStart);
        orderLogProducer.sendMessage(message);
    }
}
