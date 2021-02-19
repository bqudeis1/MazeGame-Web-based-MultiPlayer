package json;

import baha.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import items.FlashLight;
import items.Gold;
import items.Item;
import items.Key;

import java.io.IOException;

public class CustomItemDeserializer extends JsonDeserializer<Item> {

    @Override
    public Item deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        ObjectNode root = mapper.readTree(jsonParser);

        if (root.has("name") && root.get("name").asText().equals("FlashLight")) {
            return mapper.readValue(root.toString(), FlashLight.class);
        } else {
            if (root.has("name") && root.get("name").asText().equals("Gold")) {
                return mapper.readValue(root.toString(), Gold.class);
            } else {

                    return mapper.readValue(root.toString(), Key.class);


            }
        }
    }
}
