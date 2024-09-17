package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.matcher.ViewMatchers.withId;

import ru.iteco.fmhandroid.ui.utils.EspressoHelper;
import ru.iteco.fmhandroid.R;

public class Logged extends EspressoHelper {
    private LoginPage loginPage;

    public void loggedIn() {
        elementWaiting(withId(R.id.main_menu_image_button), 9000);
        checkById(R.id.main_menu_image_button);
    }

    public void loggedOut() {
        elementWaiting(withId(R.id.enter_button), 5000);
        checkById(R.id.enter_button);
    }
}