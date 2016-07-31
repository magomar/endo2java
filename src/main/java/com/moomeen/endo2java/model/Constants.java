package com.moomeen.endo2java.model;

import java.time.format.DateTimeFormatter;

public class Constants {
	public static final String DATE_TIME_FORMAT = "y-M-d H:m:s z";
	public static final String QUERY_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss Z";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    public static final DateTimeFormatter QUERY_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(QUERY_DATE_TIME_FORMAT);
}
