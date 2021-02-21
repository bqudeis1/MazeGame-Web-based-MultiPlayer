package json;

import baha.*;
import baha.Ground;
import baha.Painting;
import baha.component.*;
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
        } else {
          if (root.has("name") && root.get("name").asText().equals("Painting")) {
            return mapper.readValue(root.toString(), Painting.class);
          } else {
            if (root.has("name") && root.get("name").asText().equals("Mirror")) {
              return mapper.readValue(root.toString(), Mirror.class);
            } else {
              if (root.has("name") && root.get("name").asText().equals("Chest")) {
                return mapper.readValue(root.toString(), Chest.class);
              } else {
                if (root.has("name") && root.get("name").asText().equals("Ground")) {
                  return mapper.readValue(root.toString(), Ground.class);
                } else {
                  if (root.has("name") && root.get("name").asText().equals("Door")) {
                    return mapper.readValue(root.toString(), Door.class);
                  }

                  return null;
                }
              }
            }
          }
        }
      }
    }
  }
    }