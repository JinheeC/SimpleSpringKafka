package eda.coordinator.log.entity;

import java.util.Arrays;

public enum ReasonType {
    NORMAL(01),
    ABORTED(02),
    UNKNOWN_ERROR(03);

    private Integer value;

    ReasonType(Integer value) {
        this.value = value;
    }

    public static ReasonType valueOf(Integer value) {
        return Arrays.stream(ReasonType.values())
                     .filter(t -> t.value.equals(value))
                     .findFirst()
                     .orElseThrow(null);
    }
}
