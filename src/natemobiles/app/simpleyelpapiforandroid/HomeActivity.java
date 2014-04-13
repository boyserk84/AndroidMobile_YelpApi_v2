package natemobiles.app.simpleyelpapiforandroid;

import org.json.JSONObject;

import natemobiles.app.simpleyelpapiforandroid.interfaces.IRequestListener;
import natemobiles.app.simpleyelpapiforandroid.models.YelpResponse;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/**
 * HomeActivity
 * (Demonstration)
 * Example of Android Mobile App using Simple Yelp Api.
 * @author nkemavaha
 *
 */
public class HomeActivity extends Activity implements IRequestListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		Log.d("DEBUG", "onCreate");
		SimpleYelpClient.getRestClient().search("restaurant", 37.77493,-122.419415, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onSuccess(JSONObject successResult) {
		// TODO Auto-generated method stub
		Log.d("DEBUG", "Total result" + YelpResponse.fromJSON( successResult ).getTotal() );
		
		
	}

	@Override
	public void onFailure(JSONObject failureResult) {
		// TODO Auto-generated method stub
		
	}

}
