package eda.coordinator.log.service;

import eda.coordinator.log.dto.LogDto;

public interface LogService {
    Long create(LogDto logDto);

}
