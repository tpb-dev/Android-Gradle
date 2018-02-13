import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;


@RunWith(AndroidJUnit4.class)
public class AsyncTest {
    private class AsyncTaskSubClass extends EndpointsAsyncTask {

        @Override
        protected void onPostExecute(String result) {
            System.out.println("Post Exec overriden");
        }

    }

    private AsyncTaskSubClass asyncTask;

    @Rule
    public ActivityTestRule<MainActivity> actTestRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void initiateAsyncTask(){
        asyncTask = new AsyncTaskSubClass();
    }

    @Test
    public void testTheAsyncTask() throws Exception {
        String res = asyncTask.execute(InstrumentationRegistry.getContext()).get();
        assertEquals(res.length() > 0, true);
    }
}