package natemobiles.app.simpleyelpapiforandroid.models;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * YelpBusiness
 * 
 * Strongly-type object for Yelp Business data.
 * @author nkemavaha
 *
 */
public class YelpBusiness {

	private String id;
	
	private String name;
	
	private String imageUrl;
	
	private String mobileUrl;
	
	private double distance;
	
	private double rating;
	
	private String snippetText;
	
	private String snippetImageUrl;
	
	private String ratingImgUrl;

	
	public String getMobileUrl() {
		return mobileUrl;
	}

	public double getDistance() {
		return distance;
	}

	public double getRating() {
		return rating;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getSnippetText() {
		return snippetText;
	}

	public String getSnippetImageUrl() {
		return snippetImageUrl;
	}
	
	public String getRatingImageUrl() {
		return ratingImgUrl;
	}
	
	/**
	 * Convert raw JSON object to YelpBusiness Object
	 * @param object
	 * @return
	 */
	public static YelpBusiness fromJSON(JSONObject object) {
		YelpBusiness business = new YelpBusiness();
		try {
			business.name = object.getString("name");
			business.id = object.getString("id");
			business.rating = object.getDouble("rating");
			business.imageUrl = object.getString("image_url");
			business.mobileUrl = object.getString("mobile_url");
			business.snippetText = object.getString("snippet_text");
			business.snippetImageUrl = object.getString("snippet_image_url");
			business.distance = object.getDouble("distance");
			business.ratingImgUrl = object.getString("rating_img_url");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return business;
	}
	
	/**
	 * Convert a raw JSON array to array list of Yelp Business
	 * @param array
	 * @return
	 */
	public static ArrayList<YelpBusiness> fromJSONArray(JSONArray array) {
		ArrayList<YelpBusiness> businesses = new ArrayList<YelpBusiness>();
		
		for (int i = 0; i < array.length(); ++i) {
			try {
				businesses.add( YelpBusiness.fromJSON( array.getJSONObject( i )  ) );
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return businesses;
	}
	


}
