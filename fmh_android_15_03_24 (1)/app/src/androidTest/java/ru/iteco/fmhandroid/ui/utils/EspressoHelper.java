package ru.iteco.fmhandroid.ui.utils;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class EspressoHelper extends EspressoTestBase {


    public static void inputText(Integer resourceId, String inputText) {
        Allure.step("Ввод " + inputText + " в поле с id: " + resourceId);
        ViewInteraction textInputEditText = onView(allOf(withId(resourceId)));
        textInputEditText.check(matches(isDisplayed()));
        textInputEditText.perform(replaceText(inputText), closeSoftKeyboard());
    }
    public static void clickButton(Integer resourceId) {
        Allure.step("Тап по кнопке с id: " + resourceId);
        onView(withId(resourceId)).perform(click());
    }
    
    public void scrollAndClickButton(Integer resourceId) {
        Allure.step("Скролл и тап по кнопке с id: " + resourceId);
        onView((withId(resourceId))).perform(scrollTo(), click());
    }

    public void checkById(Integer resourceId) {
        Allure.step("Проверка того, что отображен элемент с id: " + resourceId + "с ожиданием элемента");
        elementWaiting(withId(resourceId), 4000);
        onView(withId(resourceId)).check(matches(isDisplayed()));
    }
    public void checkByIdWithText(Integer resourceId, String text) {
        Allure.step("Проверка того, что отображен элемент с id: " + resourceId + "с текстом" + text);
        ViewInteraction textView = onView(allOf(withId(resourceId), withText(text)));
        elementWaiting(withId(resourceId), 2000);
        textView.check(matches(withText(text)));
    }

    public void checkByIdNoWait(Integer resourceId) {
        Allure.step("Проверка того, что отображен элемент с id: " + resourceId + "без ожидания элемента");
        onView(withId(resourceId)).check(matches(isDisplayed()));
    }

    public void checkByString(int resourceString, String text) {
        Allure.step("Проверка того, что отображен элемент: " + resourceString + "с текстом: " + text);
        onView(withText(resourceString)).inRoot(new EspressoTestBase.ToastMatcher())
                .check(matches(isDisplayed()));
        onView(withText(resourceString)).inRoot(new EspressoTestBase.ToastMatcher())
                .check(matches(withText(text)));
    }

    public void tapHamburger(String menu_item) {
        Allure.step("Тап по кнопке-гамбургеру в главном меню и выбор пункта: " + menu_item);
        elementWaiting(withId(R.id.main_menu_image_button), 7000);
        ViewInteraction appCompatImageButton = onView((withId(R.id.main_menu_image_button)));
        appCompatImageButton.check(matches(isDisplayed()));
        appCompatImageButton.perform(click());
        ViewInteraction materialTextView = onView(allOf(withId(android.R.id.title), withText(menu_item)));
        materialTextView.check(matches(isDisplayed()));
        materialTextView.perform(click());
    }

    public void checkText(Integer resourceId, Integer resourceParent, String text) {
        Allure.step("Проверка того, что отображен элемент: " + resourceId + " с родительским view: " + resourceParent + "с текстом: " + text);
        ViewInteraction textView = onView(
                allOf(withId(resourceId), withText(text),
                        withParent(withParent(withId(resourceParent))),
                        isDisplayed()));
        textView.check(matches(withText(text)));
    }



}