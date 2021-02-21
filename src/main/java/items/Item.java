package items;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import json.CustomItemDeserializer;

@JsonDeserialize(using = CustomItemDeserializer.class)
public interface Item {
  public abstract Gold getPrice();
  public abstract String getName();
}
