package com.example.amazonsearchbe.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TimeUtils {
    private TimeUtils() {
    }

    public static long convertLocalDateTimeToEpochMilli(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
    }
}
