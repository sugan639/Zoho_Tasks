package com.util.regex;

public class RegexPattern {

	public static String CURRENCY_REGEX = "\\p{Sc}";
    public static String HTML_REGEX = "<[^>]+>";
    public static String EMAIL_REGEX = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,18}$";
    public static String ALPHA_NUMERIC_REGEX = "^[a-zA-Z0-9]+$";
    
    public static String MOBILE_10_DIGITS = "\\d{10}";

    public static String MOBILE_DASH_DOT_SPACE = "\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}";

    public static String MOBILE_WITH_EXTENSION = "\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}";

    public static String MOBILE_WITH_AREA_CODE = "\\(\\d{3}\\)-\\d{3}-\\d{4}";

	
}
