package eda.coordinator.log.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderFdsDto {
    private String onSuccess;

    private String nonTyp;

    private Long totDscCst;

    public OrderFdsDto() {
        this.onSuccess = "Y";
        this.nonTyp = "01";
        this.totDscCst = 10000L;
    }
}
