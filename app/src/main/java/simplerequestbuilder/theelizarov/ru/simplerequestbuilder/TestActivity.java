package simplerequestbuilder.theelizarov.ru.simplerequestbuilder;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import simplerequestbuilder.theelizarov.ru.simplerequestbuilder.http.HttpUtils;
import simplerequestbuilder.theelizarov.ru.simplerequestbuilder.http.Request;

/**
 * Test SimpleRequestBuilder activity
 * for testing request use service http://requestb.in/
 */
public class TestActivity extends ActionBarActivity {
    /**
     * Default simple response listener
     */
    private Request.ResponseListener responseListener = new Request.ResponseListener() {
        @Override
        public void onSuccess(HttpUtils.HttpResult httpResult) {
            if (httpResult != null) {
                Toast.makeText(TestActivity.this,
                        httpResult.getEnvelope(), Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onError(HttpUtils.HttpResult httpResult) {
            if (httpResult != null) {
                Toast.makeText(TestActivity.this,
                        httpResult.getEnvelope(), Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    /**
     * Call to tet GET request
     */
    private void testGetRequest() {
        Request.Builder builder = new Request.Builder();
        builder.setDebug(true)
                .setResponseListener(responseListener)
                .setUrl("http://requestb.in/1coag501")
                .build();
    }

    /**
     * Call to test POST request
     */
    private void testPostRequest() {
        Request.Builder builder = new Request.Builder();
        builder.setDebug(true)
                .setRequestType(Request.RequestType.POST)
                .setEnvelope("")
                .setResponseListener(responseListener)
                .setUrl("http://requestb.in/1coag501")
                .build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_post) {
            testPostRequest();
            return true;
        }
        if (id == R.id.action_get) {
            testGetRequest();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
