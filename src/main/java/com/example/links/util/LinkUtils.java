package com.example.links.util;

import org.apache.commons.lang3.RandomStringUtils;

public class LinkUtils {

    public static String generateShortLink() {
        return RandomStringUtils.random(6, "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxVvZz1234567890");
    }
}

