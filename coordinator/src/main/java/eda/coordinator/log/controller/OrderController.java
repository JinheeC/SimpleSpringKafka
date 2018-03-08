package eda.coordinator.log.controller;

import eda.coordinator.log.dto.PayloadDto;
import eda.coordinator.kafka.producer.OrderLogProducer;
import eda.coordinator.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderLogProducer orderLogProducer;

    @Autowired
    private LogService logService;

    @GetMapping(value = "/{orderNo}")
    public void orderWithAvro(@PathVariable Long orderNo) {
        PayloadDto payloadDto = new PayloadDto(orderNo);
        orderLogProducer.sendAsAvro(payloadDto.converToAvro());
    }
}
