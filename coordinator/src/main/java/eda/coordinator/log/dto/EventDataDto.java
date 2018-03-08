package eda.coordinator.log.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class EventDataDto {
    private NotificationDto notificationDto;

    private OrderFdsDto orderFdsDto;

    public EventDataDto() {
        this.notificationDto = new NotificationDto();
        this.orderFdsDto = new OrderFdsDto();
    }
}
