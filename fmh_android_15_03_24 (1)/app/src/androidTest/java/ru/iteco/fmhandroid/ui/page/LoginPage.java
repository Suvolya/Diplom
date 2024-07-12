package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static ru.iteco.fmhandroid.R.*;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;

import ru.iteco.fmhandroid.R;


public class LoginPage {

    private final int loginTextbox = R.id.login_text_input_layout;
    private final int passwordTextbox = R.id.password_text_input_layout;
    private final int loginButton = R.id.enter_button;
    private final int loginMessage = R.id.container_list_news_include_on_fragment_main;

    public void setLoginTextbox() {
        onView(withId(loginTextbox))
                .perform(replaceText("login2"), closeSoftKeyboard());

    }

    public void setPasswordTextbox() {
        onView(withId(passwordTextbox))
                .perform(replaceText("password2"), closeSoftKeyboard());
    }

    public void setLoginButton() {
        onView(withId(loginButton))
                .perform(click());

    }

    public void setLoginMessage() {
        onView(withId(loginMessage))
                .check(matches(withText("новости")));
    }
}
