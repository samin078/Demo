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

public class LoginActivityTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityScenarioRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void testLogin() {
        // Type email and password
        Espresso.onView(ViewMatchers.withId(R.id.email))
                .perform(ViewActions.typeText("saminsaiara@gmail.com"));
        Espresso.onView(ViewMatchers.withId(R.id.password))
                .perform(ViewActions.typeText("123456"));

        // Perform click on the login button
        Espresso.onView(ViewMatchers.withId(R.id.btn_login))
                .perform(ViewActions.click());

        // Wait for the authentication to complete (adjust the waiting time as needed)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Assert that MainActivity2 is launched
        Espresso.onView(ViewMatchers.withId(R.id.activity_main2))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
