package baha;

import java.util.Objects;

public class StringOutputFormatter {
    public static String getResultInAppropriateFormat(String stringToFormat){
        Objects.requireNonNull(stringToFormat);
        if(stringToFormat.isEmpty())
            return stringToFormat;
        StringBuilder result= new StringBuilder(stringToFormat);
        return String.valueOf(result.append('.').append('\n').append("Player->"));
    }
}
