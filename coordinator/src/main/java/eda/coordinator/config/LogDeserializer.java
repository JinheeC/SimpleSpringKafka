package eda.coordinator.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import eda.coordinator.log.model.Log;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

public class LogDeserializer implements Deserializer<Log> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public Log deserialize(String topic, byte[] data) {
        ObjectMapper objectMapper = new ObjectMapper();
        Log result = null;

        try {
            result = objectMapper.readValue(data, Log.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void close() {

    }
}
