package eda.coordinator.config;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.reflect.ReflectData;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.Assert;

import java.util.Iterator;
import java.util.List;

public class GenericRecordMapper {
    public static GenericData.Record mapObjectToRecord(Object object) {
        Assert.notNull(object, "object 는 null 일 수 없습니다.");

        final Schema schema = ReflectData.get().getSchema(object.getClass());
        final GenericData.Record record = new GenericData.Record(schema);

        extractSchemaValueFromObject(object, schema, record);

        return record;
    }

    public static <T> T mapRecordToObject(GenericData.Record record, Class<T> type) throws IllegalAccessException, InstantiationException {
        Assert.notNull(record, "record 는 null 일 수 없습니다.");
        Assert.notNull(type, "type 은 null 일 수 없습니다.");

        final Schema schema = ReflectData.get().getSchema(type);
        final T object = type.newInstance();

        Assert.isTrue(schema.getFields().equals(record.getSchema().getFields()), "Schema fields 가 맞지 않습니다.");

        extractObjectFromRecordValue(record, object);

        return object;
    }

    private static <T> void extractObjectFromRecordValue(GenericData.Record record, T object) {
        record.getSchema()
              .getFields()
              .stream()
              .filter(field -> field.schema().getType().equals(Schema.Type.RECORD))
              .forEach(r -> record.put(r.name(), makeSubValuesToObject(r, PropertyAccessorFactory.forDirectFieldAccess(object).getPropertyValue(r.name()))));

        record.getSchema()
              .getFields()
              .forEach(d -> PropertyAccessorFactory.forDirectFieldAccess(object).setPropertyValue(d.name(), record.get(d.name())));
    }

    private static void extractSchemaValueFromObject(Object object, Schema schema, GenericData.Record record) {
        schema.getFields().forEach(r -> record.put(r.name(), PropertyAccessorFactory.forDirectFieldAccess(object).getPropertyValue(r.name())));

        schema.getFields()
              .stream()
              .filter(field -> field.schema().getType().equals(Schema.Type.RECORD))
              .forEach(r -> record.put(r.name(), makeSubValuesToSchema(r, PropertyAccessorFactory.forDirectFieldAccess(object).getPropertyValue(r.name()))));
    }

    private static Object makeSubValuesToObject(Schema.Field field, Object origin) {

        List<Schema.Field> fieldList = field.schema().getFields();
        Iterator<Schema.Field> iterator = fieldList.iterator();

        while (iterator.hasNext()) {
            Schema.Field thisField = iterator.next();

            if (thisField.schema().getType().equals(Schema.Type.RECORD)) {
                Object object = PropertyAccessorFactory.forDirectFieldAccess(origin).getPropertyValue(thisField.name());
                PropertyAccessorFactory.forDirectFieldAccess(origin).setPropertyValue(thisField.name(), makeSubValuesToObject(thisField, object));
            } else {
                Object subObject = PropertyAccessorFactory.forDirectFieldAccess(origin).getPropertyValue(thisField.name());
                PropertyAccessorFactory.forDirectFieldAccess(origin).setPropertyValue(thisField.name(), subObject);
            }
        }

        return origin;
    }

    private static GenericData.Record makeSubValuesToSchema(Schema.Field field, Object origin) {
        GenericData.Record subRecord = new GenericData.Record(field.schema());

        List<Schema.Field> fieldList = field.schema().getFields();
        Iterator<Schema.Field> iterator = fieldList.iterator();

        while (iterator.hasNext()) {
            Schema.Field thisField = iterator.next();

            if (thisField.schema().getType().equals(Schema.Type.RECORD)) {
                subRecord.put(thisField.name(), makeSubValuesToSchema(thisField, PropertyAccessorFactory.forDirectFieldAccess(origin).getPropertyValue(thisField.name())));
            } else {
                Object valueOfField = PropertyAccessorFactory.forDirectFieldAccess(origin).getPropertyValue(thisField.name());
                subRecord.put(thisField.name(), valueOfField);
            }
        }

        return subRecord;
    }

}
