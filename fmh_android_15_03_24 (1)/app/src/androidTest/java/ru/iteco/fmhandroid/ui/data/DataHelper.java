package ru.iteco.fmhandroid.ui.data;


public class DataHelper {
    private DataHelper() {
    }

    public static class AuthInfo {
        private String login;
        private String password;

        public AuthInfo(String login, String password) {
        }
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("login2", "password2");
    }

    public static AuthInfo getOtherAuthInfo() {
        return new AuthInfo("login3", "password3");
    }

}
