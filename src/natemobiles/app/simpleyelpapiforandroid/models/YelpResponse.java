package natemobiles.app.simpleyelpapiforandroid.models;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * YelpResponse
 * 
 * Response query from Yelp Api.
 * @author nkemavaha
 *
 */
public class YelpResponse {

	private double regionCenterLatitude;
	private double regionCenterLongitude;
	private double regionLatitude;
	private double regionLongitude;
	private int total;
	private ArrayList<YelpBusiness> businesses;
	
	
	public double getRegionCenterLatitude() {
		return regionCenterLatitude;
	}


	public double getRegionCenterLongitude() {
		return regionCenterLongitude;
	}


	public double getRegionLatitude() {
		return regionLatitude;
	}


	public double getRegionLongitude() {
		return regionLongitude;
	}


	public int getTotal() {
		return total;
	}

	public ArrayList<YelpBusiness> getBusinesses() {
		return businesses;
	}
	
	/**
	 * Convert RAW JSON object to Yelp Response data
	 * @param object
	 * @return
	 */
	public static YelpResponse fromJSON( JSONObject object ){
		YelpResponse response = new YelpResponse();
		
		try {
			response.total = object.getInt("total");
			response.businesses = YelpBusiness.fromJSONArray( object.getJSONArray("businesses") );
			response.regionCenterLatitude = object.getDouble("region.center.latitude");
			response.regionCenterLongitude = object.getDouble("region.center.longitude");
			response.regionLatitude = object.getDouble("region.span.latitude_delta");
			response.regionLongitude = object.getDouble("region.span.longitude_delta");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}
	
}
