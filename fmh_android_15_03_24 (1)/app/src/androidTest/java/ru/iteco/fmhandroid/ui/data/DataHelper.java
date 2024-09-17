package ru.iteco.fmhandroid.ui.data;


import java.util.Random;

public class DataHelper {

    public static String getLogin() {
        return "login2";
    }

    public static String getPassword() {
        return "password2";
    }

    public static String generateString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();


        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
}