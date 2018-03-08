package eda.coordinator.log.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Log {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long orderId;

    @Column
    private LogType logType;

    @Column
    private String source;

    @Column
    private ReasonType reason;

    public Log(Long orderId, LogType logType, String source, ReasonType reason) {
        this.orderId = orderId;
        this.logType = logType;
        this.source = source;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Log{" +
            "id=" + id +
            ", orderId=" + orderId +
            ", logType=" + logType +
            ", source='" + source + '\'' +
            ", reason=" + reason +
            '}';
    }
}
