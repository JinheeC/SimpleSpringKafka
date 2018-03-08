package eda.coordinator.config;

import eda.coordinator.log.dto.Payload;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@Slf4j
public class AvroDeserializer<T> implements Deserializer<T> {

    //    protected final T targetType;
    protected final Class<T> targetType;

    public AvroDeserializer(Class<T> targetType) {
        this.targetType = targetType;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @SuppressWarnings("unchecked")
    @Override
    public T deserialize(String topic, byte[] data) {

//        T result = null;
        try {
            T result = null;

            if (data != null) {
                log.debug("data='{}'", DatatypeConverter.printHexBinary(data));

//                final Schema schema = ReflectData.get().getSchema(targetType.getClass());
                final Schema schema = ReflectData.get().getSchema(targetType);
                DatumReader<GenericRecord> datumReader = new GenericDatumReader<>(schema);
                Decoder decoder = DecoderFactory.get().binaryDecoder(data, null);

                GenericData.Record record = (GenericData.Record) datumReader.read(null, decoder);
                result = GenericRecordMapper.mapRecordToObject(record, targetType);
                log.debug("deserialized data='{}'", result);
            }
            return result;
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            throw new SerializationException("Can't deserialize data '" + Arrays.toString(data) + "' from topic '" + topic + "'", e);
        }
//        return result;
    }

    @Override
    public void close() {

    }
}
