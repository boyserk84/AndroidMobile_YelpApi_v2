package natemobiles.app.simpleyelpapiforandroid.models;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class YelpBusiness {

	private String id;
	
	private String name;
	
	private String imageUrl;
	
	private String mobileUrl;
	
	private float distance;
	
	private float rating;
	
	private String snippetText;
	
	private String snippetImageUrl;

	
	public String getMobileUrl() {
		return mobileUrl;
	}

	public void setMobileUrl(String mobileUrl) {
		this.mobileUrl = mobileUrl;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
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
	
	public static YelpBusiness fromJSON(JSONObject object) {
		YelpBusiness business = new YelpBusiness();
		try {
			business.name = object.getString("name");
			business.id = object.getString("id");
			business.rating = (float) object.getDouble("rating");
			business.imageUrl = object.getString("image_url");
			business.mobileUrl = object.getString("mobile_url");
			business.snippetText = object.getString("snippet_text");
			business.snippetImageUrl = object.getString("snippet_image_url");
			business.distance = (float) object.getDouble("distance");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return business;
	}
	
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
