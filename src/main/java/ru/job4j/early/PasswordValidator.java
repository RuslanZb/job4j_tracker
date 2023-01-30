package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean digit = false;
        boolean special = false;
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (password.toLowerCase().contains("qwerty")
                || password.toLowerCase().contains("12345")
                || password.toLowerCase().contains("password")
                || password.toLowerCase().contains("admin")
                || password.toLowerCase().contains("user")
        ) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        for (int i = 0; i < password.length(); i++) {
            if(!upperCase && Character.isUpperCase(password.codePointAt(i))) {
                upperCase = true;
            }
            if(!lowerCase && Character.isLowerCase(password.codePointAt(i))) {
                lowerCase = true;
            }
            if(!digit && Character.isDigit(password.codePointAt(i))) {
                digit = true;
            }
            if(!special && !Character.isLetterOrDigit(password.codePointAt(i))) {
                special = true;
            }
            if (upperCase && lowerCase && digit && special) {
                break;
            }
        }
        if (!upperCase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!lowerCase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!digit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!special) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        return password;
    }
}
