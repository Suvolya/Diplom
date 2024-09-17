package ru.iteco.fmhandroid.ui.tests;


import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;


import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.AboutPage;
import ru.iteco.fmhandroid.ui.pages.Logged;
import ru.iteco.fmhandroid.ui.pages.LoginPage;

@RunWith(AllureAndroidJUnit4.class)
public class AboutTest extends AboutPage {
    Logged logged = new Logged();
    LoginPage loginPage = new LoginPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public TestRule watcher = new ScreenshotRule();


    @Before
    public void setUp() {
        try {
            logged.loggedIn();
        }
        catch (AssertionError e) {
            loginPage.login();
        }
        tapHamburgerAbout();
    }


    @Test
    @DisplayName("Version displayed")
    @Description("information about the application version is displayed")
    public void displayVersion() {

        version();
    }
    @Test
    @DisplayName("Checking links")
    @Description("Privacy policy page opens")
    public void openPageWithPrivacyPolicy() {
        privacyPolicy();
    }

    @Test
    @DisplayName("Checking links")
    @Description("Page with terms use opens")
    public void openPageWithTermsOfUse() {
        termsOfUse();
    }


    @Test
    @DisplayName("Copyright holder displayed")
    @Description("Information about the copyright holder of the application is displayed")
    public void displayCopyright() {
        copyright();
    }
}
