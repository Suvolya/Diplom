package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static ru.iteco.fmhandroid.ui.utils.EspressoHelper.clickButton;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.utils.EspressoHelper;
import ru.iteco.fmhandroid.ui.utils.EspressoTestBase;


    public class LoginPage extends EspressoHelper {

        ViewInteraction loginField = onView(withHint("Login"));
        ViewInteraction passwordField = onView(withHint("Password"));
        public ViewInteraction getLoginField() {

            return loginField;
        }
        public ViewInteraction getPasswordField() {

            return passwordField;
        }
        public static int getLoginButtonId() {

            return R.id.enter_button;
        }
        public void login() {
            LoginPage loginPage = new LoginPage();
            loginPage.getLoginField().perform(typeText(DataHelper.getLogin()), closeSoftKeyboard());
            LoginPage loginPage2 = new LoginPage();
            loginPage2.getPasswordField().perform(typeText(DataHelper.getPassword()), closeSoftKeyboard());
            clickButton(getLoginButtonId());
        }

        public void invalidLogin() {
            LoginPage loginPage = new LoginPage();
            loginPage.getLoginField().perform(typeText("invalid"), closeSoftKeyboard());
            LoginPage loginPage2 = new LoginPage();
            loginPage2.getPasswordField().perform(typeText(DataHelper.getPassword()), closeSoftKeyboard());
            clickButton(getLoginButtonId());
        }

        public void invalidPassword() {
            LoginPage loginPage = new LoginPage();
            loginPage.getLoginField().perform(typeText(DataHelper.getLogin()), closeSoftKeyboard());
            LoginPage loginPage2 = new LoginPage();
            loginPage2.getPasswordField().perform(typeText("invalid"), closeSoftKeyboard());
            clickButton(getLoginButtonId());
        }



        public void emptyLogin() {
            LoginPage loginPage = new LoginPage();
            loginPage.getPasswordField().perform(typeText(DataHelper.getPassword()), closeSoftKeyboard());
            clickButton(getLoginButtonId());
        }

        public void emptyPassword() {
            LoginPage loginPage = new LoginPage();
            loginPage.getLoginField().perform(typeText(DataHelper.getLogin()), closeSoftKeyboard());
            clickButton(getLoginButtonId());
        }

        public void logout() {
            elementWaiting(withId(R.id.authorization_image_button), 5000);
            clickButton(R.id.authorization_image_button);
            onView(isRoot()).perform(waitForElement(withText("Log out"), 2000));
            onView(withText("Log out")).perform(click());
            elementWaiting(withId(R.id.enter_button), 5000);
        }
    }



