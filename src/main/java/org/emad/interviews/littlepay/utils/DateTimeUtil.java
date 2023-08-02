package org.emad.interviews.littlepay.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    public static LocalDateTime FromString(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, FORMATTER);
    }

    public static String ToString(LocalDateTime dateTime) {
        return FORMATTER.format(dateTime);
    }
}
