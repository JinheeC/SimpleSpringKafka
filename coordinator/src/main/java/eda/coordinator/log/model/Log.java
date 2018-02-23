package eda.coordinator.log.model;

import lombok.Data;

@Data
public class Log {
    private Long id;

    private LogType logType;

    private String source;

    private ReasonType reason;

    public Log() {
    }

    public Log(Long id, boolean isStart) {
        this.id = id;
        this.reason = ReasonType.NORMAL;
        this.source = "start position";
        selectOrderType(isStart);
    }

    public Log(Long id, String source, Integer reason) {
        this.id = id;
        this.source = source;
        this.reason = ReasonType.valueOf(reason);
        this.logType = LogType.ERROR_ORDER;
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
        return "Log{" +
            "id=" + id +
            ", logType=" + logType +
            ", source='" + source + '\'' +
            ", reason=" + reason +
            '}';
    }
}
