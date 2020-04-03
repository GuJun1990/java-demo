package org.example.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;

import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gujun@qiyi.com
 * @since 2020/4/3 9:48 上午
 */
public class DemoProtobuf {

    private QiwenSchema.QiwenSchemaInfo constructQiwenSchemaInfo() {
        QiwenSchema.QiwenSchemaInfo schemaInfo = QiwenSchema.QiwenSchemaInfo.newBuilder()
                .setId(10086L)
                .setTimestamp(System.currentTimeMillis())
                .addAllStringArray(Arrays.asList("1", "a", "2", "b"))
                .addAllLongArray(Arrays.asList(1L,2L,3L,4L,5L,6L,7L,8L,9L))
                .build();
        return schemaInfo;
    }

    private Map<String, Object> convertToMap(Message message) {
        Map<Descriptors.FieldDescriptor, Object> map = message.getAllFields();
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
            System.out.println("field name: " + entry.getKey().getName());
            System.out.println("java type: " + entry.getKey().getJavaType());
            System.out.println("field type: " + entry.getKey().getType());
            System.out.println("field value: " + entry.getValue());
        }
        return new HashMap<>();
    }

    public static void main(String[] args) {
        DemoProtobuf demo = new DemoProtobuf();
        QiwenSchema.QiwenSchemaInfo qiwenSchemaInfo = demo.constructQiwenSchemaInfo();
        demo.convertToMap(qiwenSchemaInfo);
    }

}
