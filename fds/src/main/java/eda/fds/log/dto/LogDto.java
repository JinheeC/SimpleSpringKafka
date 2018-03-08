package eda.fds.log.dto;

import eda.fds.log.LogType;
import eda.fds.log.ReasonType;
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
