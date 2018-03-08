package eda.coordinator.log.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class EventData {
    private NotificationDto notificationDto;

    private OrderFdsDto orderFdsDto;

    public EventData() {
        this.notificationDto = new NotificationDto();
        this.orderFdsDto = new OrderFdsDto();
    }
}
