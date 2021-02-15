package common;

import player.Direction;

import java.util.Objects;

public class StringOutputFormatter {
    //TODO: rename the methods in this class.
    public static String getResultInAppropriateFormat(String stringToFormat){
        Objects.requireNonNull(stringToFormat);
        if(stringToFormat.isEmpty())
            return stringToFormat;
        StringBuilder result= new StringBuilder(stringToFormat);
        return String.valueOf(result.append('.').append('\n').append("Player->"));
    }
    public static String getDirectionInAppropriateFormat(Direction dir){
        return "now you are facing " + dir;

    }
}
