package eda.coordinator.log.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationDto {
    private String uniqueName;

    private Long notificationId;

    public NotificationDto() {
        this.uniqueName = "this is test Notification";
        this.notificationId = 1L;
    }
}
