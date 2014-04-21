package natemobiles.app.simpleyelpapiforandroid;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import natemobiles.app.simpleyelpapiforandroid.adapters.YelpBusinessAdapter;
import natemobiles.app.simpleyelpapiforandroid.interfaces.IRequestListener;
import natemobiles.app.simpleyelpapiforandroid.models.YelpBusiness;
import natemobiles.app.simpleyelpapiforandroid.models.YelpResponse;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

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
		Log.d("DEBUG", "Total result" + YelpResponse.fromJSON( successResult ).getTotal() );

		try {
			JSONArray businesses = successResult.getJSONArray("businesses");
			results = YelpBusiness.fromJSONArray( businesses );
			resultAdapter.addAll( results );
			resultAdapter.notifyDataSetInvalidated();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onFailure(JSONObject failureResult) {
		Log.d("DEBUG", "Failure" + failureResult.toString() );
	}

}
