package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.utils.EspressoHelper;

public class AboutPage extends EspressoHelper {
    public void tapHamburgerAbout() {
        elementWaiting(withId(R.id.main_menu_image_button), 6000);
        checkById(R.id.main_menu_image_button);
        clickButton(R.id.main_menu_image_button);

        ViewInteraction materialTextView = onView(allOf(withId(android.R.id.title), withText("About")));
        materialTextView.check(matches(isDisplayed()));
        materialTextView.perform(click());

        onView(allOf(withId(R.id.about_version_title_text_view), withText("Version:"), isDisplayed()));
    }
    public void version() {
        checkByIdNoWait(R.id.about_version_value_text_view);
    }

    public void copyright() {
        checkByIdNoWait(R.id.about_company_info_label_text_view);
    }

    public void privacyPolicy() {
        ViewInteraction materialTextView = onView(withId(R.id.about_privacy_policy_label_text_view));
        materialTextView.check(matches(isDisplayed()));
        materialTextView.perform(click());
        materialTextView.check(matches(withText("Privacy Policy:")));
    }

    public void termsOfUse() {
        ViewInteraction materialTextView = onView(withId(R.id.about_terms_of_use_label_text_view));
        materialTextView.check(matches(isDisplayed()));
        materialTextView.perform(click());
        materialTextView.check(matches(withText("Terms of use:")));
    }
}