package natemobiles.app.simpleyelpapiforandroid.sampleActivity;

import java.util.ArrayList;

import natemobiles.app.simpleyelpapiforandroid.R;
import natemobiles.app.simpleyelpapiforandroid.SimpleYelpClient;
import natemobiles.app.simpleyelpapiforandroid.adapters.YelpBusinessAdapter;
import natemobiles.app.simpleyelpapiforandroid.interfaces.IRequestListener;
import natemobiles.app.simpleyelpapiforandroid.models.YelpBusiness;
import natemobiles.app.simpleyelpapiforandroid.models.YelpFilterRequest;
import natemobiles.app.simpleyelpapiforandroid.models.YelpResponse;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

/**
 * HomeActivity
 * (Demonstration)
 * Example of Android Mobile App using Simple Yelp API.
 * @author nkemavaha
 *
 */
public class HomeActivity extends Activity implements IRequestListener{

	private YelpBusinessAdapter resultAdapter;
	
	private ArrayList<YelpBusiness> results;
	
	private ListView resultView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		resultView = (ListView) findViewById( R.id.lvResult );
		results = new ArrayList<YelpBusiness>();
		resultAdapter = new YelpBusinessAdapter( getBaseContext(), results);
		resultView.setAdapter( resultAdapter );
		
		/////////////////////////////////////
		// How to call SimpleYelpClient
		////////////////////////////////////
		
		// (1) Simplest way to request data from Yelp
		//SimpleYelpClient.getRestClient().search("restaurant", 37.77493,-122.419415, this);
		
		// or
		// (2) Customized request data from Yelp
		YelpFilterRequest requestData = new YelpFilterRequest();
		requestData.longitude = -122.419415;
		requestData.latitude = 37.77493;
		requestData.term = "restaurant";
		requestData.categoryFilter = "thai";
		requestData.sortType = YelpFilterRequest.SORT_BY_DISTANCE;
		SimpleYelpClient.getRestClient().search( requestData, this );
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
		YelpResponse response = YelpResponse.fromJSON( successResult );
		results = response.getBusinesses();
		Log.d("DEBUG", results.size() + "");
		resultAdapter.addAll( results );
		resultAdapter.notifyDataSetInvalidated();
	}

	@Override
	public void onFailure(JSONObject failureResult) {
		Log.d("DEBUG", failureResult.toString());
		Toast.makeText( getBaseContext(), "Failure: " + failureResult.toString(), Toast.LENGTH_SHORT).show();
	}

}
