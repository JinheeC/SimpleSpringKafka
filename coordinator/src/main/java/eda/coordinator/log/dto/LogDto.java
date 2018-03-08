package eda.coordinator.log.dto;

import eda.coordinator.log.entity.Log;
import eda.coordinator.log.entity.LogType;
import eda.coordinator.log.entity.ReasonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDto {
    private Long orderId;

    private LogType logType;

    private String source;

    private ReasonType reason;

    public LogDto(Long orderId, boolean isStart) {
        this.orderId = orderId;
        this.reason = ReasonType.NORMAL;
        this.source = "start position";
        selectOrderType(isStart);
    }

    public LogDto(Long orderId, ReasonType reason) {
        this.orderId = orderId;
        this.logType = LogType.CANCEL_ORDER;
        this.source = "from customer";
        this.reason = reason;
    }

    public LogDto(Long orderId, String source, Integer reason) {
        this.orderId = orderId;
        this.source = source;
        this.reason = ReasonType.valueOf(reason);
        this.logType = LogType.ERROR_ORDER;
    }

    public Log convertToLog() {
        return new Log(orderId, logType, source, reason);
    }

    private void selectOrderType(boolean isStart) {
        if (isStart) {
            this.logType = LogType.START_ORDER;
        } else {
            this.logType = LogType.STOP_ORDER;
        }
    }

    @Override
    public String toString() {
        return "LogDto{" +
            "orderId=" + orderId +
            ", logType=" + logType +
            ", source='" + source + '\'' +
            ", reason=" + reason +
            '}';
    }
}
