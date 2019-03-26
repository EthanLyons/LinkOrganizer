package deepdive.cnm.edu.linkorganizer.controller;

import static android.support.test.espresso.action.ViewActions.click;
import static org.junit.Assert.*;

import android.support.test.rule.ActivityTestRule;
import deepdive.cnm.edu.linkorganizer.R;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJunit4.class)
public class MainActivityTest {

  @Rule
  public ActivityTestRule<MainActivity> activityTestRule =
      new ActivityTestRule<MainActivity>(MainActivity.class);

  @Test
  public void navigateToHistory(){
    onView(withid(R.id.nav_gallery))
        .perform(click());
  }

  @Before
  public void setUp() throws Exception {
  }
}