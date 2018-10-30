package com._onesafe.json;

import java.io.IOException;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/**
 * Created by onesafe on 30/10/2018.
 */
@JsonSerialize(using=IntOrString.IntOrStringSerializer.class)
@JsonDeserialize(using=IntOrString.IntOrStringDeserializer.class)
@JsonAdapter(IntOrString.IntOrStringAdapter.class)
public class IntOrString {
    private final boolean isInt;
    private final String strValue;
    private final Integer intValue;

    public IntOrString(final String value) {
        this.isInt = false;
        this.strValue = value;
        this.intValue = null;
    }

    public IntOrString(final int value) {
        this.isInt = true;
        this.intValue = value;
        this.strValue = null;
    }

    public boolean isInteger() {
        return isInt;
    }

    public String getStrValue() {
        if (isInt) {
            throw new IllegalStateException("Not a string");
        }
        return strValue;
    }

    public Integer getIntValue() {
        if (!isInt) {
            throw new IllegalStateException("Not an integer");
        }
        return intValue;
    }

    @Override
    public String toString() {
        return (isInt ? String.valueOf(intValue) : strValue);
    }

    @Override
    public boolean equals(Object o) {
        return this == o || (o instanceof IntOrString && equals((IntOrString) o));
    }

    private boolean equals(IntOrString o) {
        if (isInt != o.isInt) return false;
        return isInt ? Objects.equals(intValue, o.intValue) : Objects.equals(strValue, o.strValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isInt, strValue, intValue);
    }

    public static class IntOrStringAdapter extends TypeAdapter<IntOrString> {
        @Override
        public void write(JsonWriter jsonWriter, IntOrString intOrString) throws IOException {
            if (intOrString.isInteger()) {
                jsonWriter.value(intOrString.getIntValue());
            } else {
                jsonWriter.value(intOrString.getStrValue());
            }
        }

        @Override
        public IntOrString read(JsonReader jsonReader) throws IOException {
            final JsonToken nextToken = jsonReader.peek();
            if (nextToken == JsonToken.NUMBER) {
                return new IntOrString(jsonReader.nextInt());
            } else if (nextToken == JsonToken.STRING) {
                return new IntOrString(jsonReader.nextString());
            } else {
                throw new IllegalStateException("Could not deserialize to IntOrString. Was " + nextToken);
            }
        }
    }

    public static class IntOrStringSerializer extends StdSerializer<IntOrString> {

        public IntOrStringSerializer() {
            this(null);
        }

        public IntOrStringSerializer(Class<IntOrString> t) {
            super(t);
        }

        @Override
        public void serialize(IntOrString value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
            if (value.isInteger()) {
                gen.writeNumber(value.getIntValue());
            } else {
                gen.writeString(value.getStrValue());
            }
        }
    }

    public static class IntOrStringDeserializer extends StdDeserializer<IntOrString> {

        public IntOrStringDeserializer() {
            this(null);
        }

        public IntOrStringDeserializer(Class<IntOrString> t) {
            super(t);
        }

        @Override
        public IntOrString deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode node = jp.getCodec().readTree(jp);

            if (node.isInt()) {
                return new IntOrString(node.intValue());
            } else {
                String value = jp.getValueAsString();
                if(value != null && !value.isEmpty() && !value.equals("null"))
                    return new IntOrString(value);
                return null;
            }
        }
    }
}
