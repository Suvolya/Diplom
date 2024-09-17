package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotEquals;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.utils.EspressoHelper;

public class NewsPage extends EspressoHelper {
    public void checkEdit() {
        checkById(R.id.edit_news_material_button);
        clickButton(R.id.edit_news_material_button);
        checkById(R.id.add_news_image_view);
    }
    public void createNews() {
        String date = getCurrentDate();
        String time = getCurrentTime();
        String category = "Объявление";
        String title = DataHelper.generateString();
        String description = "Объявление тест";
        clickButton(R.id.add_news_image_view);
        clickDropDownCategory();
        inputTitle(title);
        inputDate(date);
        inputCurrentTime();
        inputText(R.id.news_item_description_text_input_edit_text, description);
        scrollAndClickButton(R.id.save_button);

        elementWaiting(withId(R.id.filter_news_material_button), 3000);
        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.filter_news_material_button)));
        materialButton4.perform(click());

        ViewInteraction textInputEditText = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
        textInputEditText.perform(click());
        textInputEditText.perform(replaceText("Объявление"));

        ViewInteraction textInputEditText2 = onView(allOf(withId(R.id.news_item_publish_date_start_text_input_edit_text)));
        textInputEditText2.perform(replaceText(getCurrentDate()));
        ViewInteraction textInputEditText3 = onView(allOf(withId(R.id.news_item_publish_date_end_text_input_edit_text)));
        textInputEditText3.perform(replaceText(getCurrentDate()));

        elementWaiting(withId(R.id.filter_button), 3000);
        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.filter_button), withText("Filter")));
        materialButton7.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.news_item_title_text_view), withText(title),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView.check(matches(withText(title)));
    }

    public static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    public void clickDropDownCategory() {
        ViewInteraction checkableImageButton = onView(
                allOf(withId(com.google.android.material.R.id.text_input_end_icon), withContentDescription("Show dropdown menu"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        checkableImageButton.perform(click());
    }
    public void inputTitle(String title) {
        ViewInteraction textInputEditText = onView(withId(R.id.news_item_title_text_input_edit_text));
        textInputEditText.perform(click());
        textInputEditText.perform(replaceText(title));
    }

    public void inputDate(String date) {
        ViewInteraction textInputEditText = onView(allOf(withId(R.id.news_item_publish_date_text_input_edit_text)));
        textInputEditText.perform(replaceText(date));
    }
    public void inputCurrentTime() {
        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.news_item_publish_time_text_input_edit_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_publish_time_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText4.perform(click());

        ViewInteraction materialButton5 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton5.perform(scrollTo(), click());
    }

    public void warnDeleteNews() {
        elementWaiting(withId(R.id.news_list_recycler_view), 8000);
        onView(withId(R.id.news_list_recycler_view))
                .perform(actionOnItemAtPosition(0, clickChildViewWithId(R.id.delete_news_item_image_view)));
        onView(withText(R.string.irrevocable_deletion))
                .check(matches(withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future.")));
    }

    public void deleteNews() {
        int countBeforeDelete = EspressoHelper.getRecyclerViewItemCount();
        warnDeleteNews();
        ViewInteraction materialButton3 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton3.perform(scrollTo(), click());
        elementWaiting(withId(R.id.news_list_recycler_view), 4000);
        int countAfterDelete = EspressoHelper.getRecyclerViewItemCount();
        assertNotEquals(countBeforeDelete, countAfterDelete);
    }


}

