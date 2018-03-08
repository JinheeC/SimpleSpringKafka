package eda.coordinator.log.service;

import eda.coordinator.log.dto.LogDto;
import eda.coordinator.log.entity.Log;
import eda.coordinator.log.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService{

    @Autowired
    private LogRepository logRepository;

    @Override
    public Long create(LogDto logDto) {
        Log log = logDto.convertToLog();
        return logRepository.save(log).getId();
    }
}
