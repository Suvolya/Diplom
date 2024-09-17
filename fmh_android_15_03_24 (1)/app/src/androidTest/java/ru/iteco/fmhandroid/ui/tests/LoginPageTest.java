package ru.iteco.fmhandroid.ui.tests;


import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pages.Logged;
import ru.iteco.fmhandroid.ui.pages.LoginPage;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;


import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;

@RunWith(AllureAndroidJUnit4.class)

public class LoginPageTest extends LoginPage {
    LoginPage loginPage = new LoginPage();
    Logged logged = new Logged();



    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void checkLogout() {
        try {
            logged.loggedOut();
        } catch (Exception e) {
            loginPage.logout();
            logged.loggedOut();
        }
    }

    @Test
    @DisplayName("Positive scenario 1")
    @Description("Valid login and password authorization")
    public void validLoginAndPassword() {
        login();
        checkById(R.id.authorization_image_button);

    }

    @Test
    @DisplayName("Positive scenario 2")
    @Description("Logout of app")
    public void shouldLogout() {
        login();
        logout();
    }

    @Test
    @DisplayName("Negative scenario 2")
    @Description("Empty login and valid password authorization")
    public void emptyLoginAndValidPassword() {
        emptyLogin();
        checkByString(R.string.empty_login_or_password,"Login and password cannot be empty");

    }

    @Test
    @DisplayName("Negative scenario 3")
    @Description("Empty password and valid login authorization")
    public void emptyPasswordAndValidLogin() {
        emptyPassword();
        checkByString(R.string.empty_login_or_password,"Login and password cannot be empty");

    }

    @Test
    @DisplayName("Negative scenario 4")
    @Description("Valid login and invalid password authorization")
    public void validLoginAndInvalidPassword() {
        invalidPassword();
        checkByString(R.string.wrong_login_or_password,"Something went wrong. Try again later.");

    }

    @Test
    @DisplayName("Negative scenario 5")
    @Description("Invalid login and valid password authorization")
    public void invalidLoginAndValidPassword() {
        invalidLogin();
        checkByString(R.string.wrong_login_or_password,"Something went wrong. Try again later.");

    }



}

