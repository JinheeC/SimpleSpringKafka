package eda.coordinator.log.dto;

import eda.coordinator.config.GenericRecordMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.avro.generic.GenericData;

import java.util.Date;

@Data
@AllArgsConstructor
public class Payload {
    private Long orderNo;

    private Long timestamp;

    private EventData eventData;

    public Payload() {
        this.eventData = new EventData();
    }

    public Payload(Long orderNo) {
        this.orderNo = orderNo;
        this.timestamp = new Date().getTime();
        this.eventData = new EventData();
    }

    public GenericData.Record converToAvro() {
        return GenericRecordMapper.mapObjectToRecord(this);
    }

}
