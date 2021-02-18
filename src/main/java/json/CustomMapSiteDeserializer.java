package json;

import baha.MapSite;
import baha.Room;
import baha.Seller;
import baha.Wall;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class CustomMapSiteDeserializer extends JsonDeserializer<MapSite> {

  @Override
  public MapSite deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException, JsonProcessingException {
    ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
    ObjectNode root = mapper.readTree(jsonParser);

    if (root.has("name") && root.get("name").asText().equals("Room")) {
      return mapper.readValue(root.toString(), Room.class);
    } else {
      if (root.has("name") && root.get("name").asText().equals("Wall")) {
        return mapper.readValue(root.toString(), Wall.class);
      } else {
        if (root.has("name") && root.get("name").asText().equals("Seller")) {
          return mapper.readValue(root.toString(), Seller.class);
        }

        return null;
      }
    }
  }
}