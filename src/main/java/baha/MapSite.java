package baha;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import json.CustomMapSiteDeserializer;


@JsonDeserialize(using = CustomMapSiteDeserializer.class)
public interface MapSite extends Cloneable {

  Object clone() throws CloneNotSupportedException;

  default String look(){return getClass().getSimpleName();}
}
