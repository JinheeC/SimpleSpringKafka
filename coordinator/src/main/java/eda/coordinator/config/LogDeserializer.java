package eda.coordinator.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import eda.coordinator.log.dto.LogDto;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

//public class LogDeserializer implements Deserializer<LogDto> {
//    @Override
//    public void configure(Map<String, ?> configs, boolean isKey) {
//
//    }
//
//    @Override
//    public LogDto deserialize(String topic, byte[] data) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        LogDto result = null;
//
//        try {
//            result = objectMapper.readValue(data, LogDto.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }
//
//    @Override
//    public void close() {
//
//    }
//}
