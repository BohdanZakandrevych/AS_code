package pl.as.domain;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

public final class ValidationUtils {
    public static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private ValidationUtils() {
    }

    public static <T> T requireNotNull(T value, String fieldName) {
        if (value == null) {
            throw new IllegalArgumentException(fieldName + " jest wymagane");
        }
        return value;
    }

    public static String requireNotBlank(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " jest wymagane");
        }
        return value;
    }

    public static String requireValidEmail(String value, String fieldName) {
        requireNotBlank(value, fieldName);
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException(fieldName + " ma niepoprawny format");
        }
        return value;
    }

    public static LocalDateTime requireFutureOrPresent(LocalDateTime value, String fieldName) {
        if (value == null) {
            return null;
        }
        if (value.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException(fieldName + " musi być >= teraz");
        }
        return value;
    }
}
