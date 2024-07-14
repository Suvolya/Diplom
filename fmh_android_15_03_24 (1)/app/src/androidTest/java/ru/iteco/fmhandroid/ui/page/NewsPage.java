package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.PickerActions.setDate;
import static androidx.test.espresso.contrib.PickerActions.setTime;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.widget.DatePicker;
import android.widget.TimePicker;

import ru.iteco.fmhandroid.R;

public class NewsPage {
    private final int menuBtn = R.id.main_menu_image_button;
    private final int menuList = R.id.container_custom_app_bar_include_on_fragment_main;
    private final int title = android.R.id.title;
    private final int editBtn = R.id.edit_news_material_button;
    private final int addBtn = R.id.add_news_image_view;
    private final int category = R.id.news_item_category_text_auto_complete_text_view;
    private final int categoryInput = R.id.news_item_category_text_auto_complete_text_view;
    private final int date = R.id.news_item_publish_date_text_input_edit_text;
    private final int OkBtn = android.R.id.button1;
    private final int fixDate = R.id.news_item_create_date_text_input_layout;
    private final int time = R.id.news_item_publish_time_text_input_layout;
    private final int fixTime = R.id.news_item_publish_time_text_input_layout;
    private final int descriptionTextBox = R.id.news_item_description_text_input_edit_text;
    private final int SaveBtn = R.id.save_button;
    private final int listNews = R.id.container_list_news_include_on_fragment_main;




    public void clickMenuButn() {
        onView(withId(menuBtn))
                .perform(click());
    }

    public void selectMenuItem(String Item, String ItemTitle) {
        onView(withId(menuList))
                .check(matches(withText(Item)))
                        .perform(click());

        onView(withId(title))
                .check(matches(withText(ItemTitle)))
                .perform(click());
    }

    public void addNews(String Category, String CategoryItem) {
        onView(withId(editBtn))
                .perform(click());

        onView(withId(addBtn))
                .perform(click());

        onView(withId(category))
                .check(matches(withText(Category)))
                .perform(click());

        onView(withId(categoryInput))
                .check(matches(withText(CategoryItem)))
                .perform(click());

    }

    public void testSetDateInDatePicker () {
        // Показать выбор даты
        onView(withId(date))
                .perform (click());

        // Установить дату в виджете выбора даты
        onView(isAssignableFrom(DatePicker.class)).perform(setDate( 2024 , 07 , 13 )) ;


        // Подтвердить выбранную дату
        onView(withId(OkBtn)).perform(click());

        // Проверить правильность выбранной даты
        onView(withId(fixDate))
                .check(matches(withText("10/30/1980")));

    }

    public void testSetTimeInTimePicker () {
        // Показать выбор даты
        onView(withId(time)).perform(click());

        // Установить время в виджете выбора вида
        onView(isAssignableFrom(TimePicker.class)).perform(setTime(14,30));

        // Подтвердить выбранное время
        onView(withId(OkBtn)).perform(click());

        // Проверить выбранную дату
        onView(withId(fixTime))
                .check(matches(withText("12:36")));
    }

    public void setDescriptionTextbox() {
        onView(withId(descriptionTextBox))
                .perform(click(), replaceText("объявление"), closeSoftKeyboard(), scrollTo());

    }

    public void clickSaveButton() {
        onView(withId(SaveBtn))
                .perform (click());
    }

    public void setDescriptionTextBox() {
        onView(withId(listNews))
                .check(matches(withText("объявление")));
    }


}

