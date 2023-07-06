package com.example.demo;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
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

public class MainActivity4Test {

    @Rule
    public ActivityScenarioRule<MainActivity4> activityScenarioRule = new ActivityScenarioRule<>(MainActivity4.class);


    @Test
    public void testAppName() {
        Espresso.onView(withText("HeartLive")).check(matches(isDisplayed()));
    }

    @Test
    public void testFabClick() {
        // Perform click on the FloatingActionButton
        Espresso.onView(ViewMatchers.withId(R.id.fab))
                .perform(ViewActions.click());

        // Assert that the MainActivity5 is launched
        Espresso.onView(ViewMatchers.withId(R.id.activity_main5))
                .check(matches(isDisplayed()));
    }
/*
    @Test
    public void testDataLoaded() {
        // Wait for the data to be loaded from the database
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Assert that the RecyclerView is displayed and contains data
        Espresso.onView(ViewMatchers.withId(R.id.rr))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.rr))
                .check(new RecyclerViewItemCountAssertion(> 0)); // Replace > 0 with the expected item count
    }*/
}