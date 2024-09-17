package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.Logged;
import ru.iteco.fmhandroid.ui.pages.LoginPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;

@RunWith(AllureAndroidJUnit4.class)
public class AddNewsTest extends NewsPage {
    Logged logged = new Logged();
    LoginPage loginPage = new LoginPage();
    NewsPage newsPage = new NewsPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            logged.loggedIn();
        } catch (AssertionError e) {
            loginPage.login();
        }
        tapHamburger("News");
        checkEdit();
    }

    @Test
    @DisplayName("Create news, positive scenario")
    @Description("The card is saved in the \"Advertisement\" category with the current publication date and creation date and description \"Advertisement test\"")
    public void shouldCreateNews() {
        createNews();
    }

    @Test
    @DisplayName("Deleting news")
    @Description("The first card will disappear and the remaining cards will move up")
    public void shouldDeleteNews() {
        deleteNews();
    }
}




