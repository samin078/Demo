package com.example.demo;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;


import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)

public class MainActivity5Test {
    @Rule
    public ActivityScenarioRule<MainActivity5> activityScenarioRule = new ActivityScenarioRule<>(MainActivity5.class);

    @Test
    public void testSaveData() {
        // Enter data into the EditText fields
        onView(withId(R.id.editTextTextPersonName4)).perform(ViewActions.typeText("120"));
        onView(withId(R.id.editTextTextPersonName5)).perform(ViewActions.typeText("80"));
        onView(withId(R.id.editTextTextPersonName6)).perform(ViewActions.typeText("72"));
        onView(withId(R.id.editTextDate)).perform(ViewActions.typeText("7/5/2023"));
        onView(withId(R.id.editTextTime)).perform(ViewActions.typeText("2:30"));
        onView(withId(R.id.editTextTextPersonName7)).perform(ViewActions.typeText("ok"));
        Espresso.onView(ViewMatchers.withId(R.id.btn_update)).perform(click());
    }
}