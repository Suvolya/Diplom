package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.utils.EspressoHelper;



public class QuotesPage extends EspressoHelper {
        public void openQuotes() {
            checkById(R.id.our_mission_image_button);
            clickButton(R.id.our_mission_image_button);
            checkById(R.id.our_mission_title_text_view);
        }
        public void fullQuotes() {
            String text = "Нет шаблона и стандарта, есть только дух, который живет в разных домах по-разному. Но всегда он добрый, любящий и помогающий.";
            ViewInteraction recyclerView = onView(
                    allOf(withId(R.id.our_mission_item_list_recycler_view),
                            childAtPosition(
                                    withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                    0)));
            recyclerView.perform(actionOnItemAtPosition(0, click()));

            ViewInteraction textView2 = onView(allOf(withId(R.id.our_mission_item_description_text_view), withText(text)));
            textView2.check(matches(withText(text)));
        }
}

