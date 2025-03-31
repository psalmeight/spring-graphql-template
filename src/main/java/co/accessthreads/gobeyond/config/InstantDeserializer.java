package co.accessthreads.gobeyond.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.Instant;

public class InstantDeserializer extends StdDeserializer<Instant> {

    public InstantDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Instant deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);

        JsonNode epochSecondNode = node.get("epochSecond");
        JsonNode nanoNode = node.get("nano");

        Long epochSecond = epochSecondNode != null ? epochSecondNode.longValue() : null;
        Long nano = nanoNode != null ? nanoNode.longValue() : null;

        if (epochSecond == null || nano == null) {
            return null;
        }

        return Instant.ofEpochSecond(epochSecond, nano);
    }
}