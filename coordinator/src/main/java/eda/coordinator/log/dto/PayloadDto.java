package eda.coordinator.log.dto;

import eda.coordinator.config.GenericRecordMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.avro.generic.GenericData;

import java.util.Date;

@Data
@AllArgsConstructor
public class PayloadDto {
    private Long orderNo;

    private Long timestamp;

    private EventDataDto eventDataDto;

    public PayloadDto() {
        this.eventDataDto = new EventDataDto();
    }

    public PayloadDto(Long orderNo) {
        this.orderNo = orderNo;
        this.timestamp = new Date().getTime();
        this.eventDataDto = new EventDataDto();
    }

    public GenericData.Record converToAvro() {
        return GenericRecordMapper.mapObjectToRecord(this);
    }

}
