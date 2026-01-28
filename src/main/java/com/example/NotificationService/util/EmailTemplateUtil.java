package com.example.NotificationService.util;

public class EmailTemplateUtil {

    private EmailTemplateUtil() {}

    public static String buildPlainTextEmail(String message) {
        return """
                Hello,

                %s

                Regards,
                Ecommerce Team
                """.formatted(message);
    }
}