package com.order.system.common.utils.conterver.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Map;

/**
 * @author Zhao Junjian
 */
public class StringToMapSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String val = value;
        if (value == null || value.isEmpty()) {
            val = "{}";
        }
        gen.writeObject(new ObjectMapper().readValue(val, Map.class));
    }

}
