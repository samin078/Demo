package com.example.demo;

import static org.junit.Assert.*;



import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)

public class DetailActivityTest {

    @Rule
    public ActivityScenarioRule<DetailActivity> activityScenarioRule = new ActivityScenarioRule<>(DetailActivity.class);

    @Test
    public void testDeleteButton() {
        // Perform click on the deleteButton
        Espresso.onView(ViewMatchers.withId(R.id.btnList))
                .check(ViewAssertions.matches(ViewMatchers.isClickable()))
                .perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.btnList))
                .perform(ViewActions.pressMenuKey());


        Espresso.onView(ViewMatchers.withId(R.id.deleteButton))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.click());


    }

    @Test
    public void testEditButton() {
        // Perform click on the editButton
        Espresso.onView(ViewMatchers.withId(R.id.editButton))
                .perform(ViewActions.click());

        // Assert that the UpdateActivity is launched with the correct extras

        Espresso.onView(ViewMatchers.withId(R.id.update_activity))
               .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        /*
       Espresso.onView(ViewMatchers.withId(R.id.editTextTextPersonName4))
                .check(ViewAssertions.matches(ViewMatchers.withText("<value>"))); // Replace <value> with the expected value
        Espresso.onView(ViewMatchers.withId(R.id.editTextTextPersonName5))
                .check(ViewAssertions.matches(ViewMatchers.withText("Systolic: <value>"))); // Replace <value> with the expected value
        Espresso.onView(ViewMatchers.withId(R.id.editTextTextPersonName6))
                .check(ViewAssertions.matches(ViewMatchers.withText("Heart Rate: <value>"))); // Replace <value> with the expected value
        Espresso.onView(ViewMatchers.withId(R.id.editTextTime))
                .check(ViewAssertions.matches(ViewMatchers.withText("Time: <value>"))); // Replace <value> with the expected value
        Espresso.onView(ViewMatchers.withId(R.id.editTextDate))
                .check(ViewAssertions.matches(ViewMatchers.withText("Date: <value>"))); // Replace <value> with the expected value
        Espresso.onView(ViewMatchers.withId(R.id.editTextTextPersonName7))
                .check(ViewAssertions.matches(ViewMatchers.withText("Comment: <value>"))); // Replace <value> with the expected value*/
    }
}

