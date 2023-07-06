package com.example.demo;

import static org.junit.Assert.*;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)

public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testSplashScreen() {
        // Wait for the specified duration (4000 milliseconds)
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Assert that MainActivity4 is launched
        Espresso.onView(ViewMatchers.withId(R.id.activity_main4))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}