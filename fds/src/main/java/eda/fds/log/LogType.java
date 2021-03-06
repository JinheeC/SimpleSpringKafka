package eda.fds.log;

import java.util.Arrays;

public enum LogType {
    START_ORDER(01),
    ERROR_ORDER(02),
    STOP_ORDER(03),
    CANCEL_ORDER(04);

    private Integer value;

    LogType(Integer value) {
        this.value = value;
    }

    public static LogType valueOf(Integer value) {
        return Arrays.stream(LogType.values())
                     .filter(t -> t.value.equals(value))
                     .findFirst()
                     .orElseThrow(null);
    }
}