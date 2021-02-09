package json;

import baha.Door;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CustomDoorSerializer extends StdSerializer<Door> {

  public CustomDoorSerializer() {
    this(null);
  }

  protected CustomDoorSerializer(Class<Door> t) {
    super(t);
  }

  @Override
  public void serialize(
      Door door, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
      throws IOException {

    jsonGenerator.writeObject((door).getRoom1().getRoomNo());
    jsonGenerator.writeObject((door).getRoom2().getRoomNo());

    jsonGenerator.writeStartObject();
    jsonGenerator.writeStringField(
        "link", (door).getRoom1().getRoomNo() + "," + (door).getRoom2().getRoomNo());

    jsonGenerator.writeEndObject();
  }
}
