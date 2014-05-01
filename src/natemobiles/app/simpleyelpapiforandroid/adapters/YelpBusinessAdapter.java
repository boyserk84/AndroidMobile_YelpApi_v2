package natemobiles.app.simpleyelpapiforandroid.adapters;

import java.util.List;

import com.squareup.picasso.Picasso;

import natemobiles.app.simpleyelpapiforandroid.R;
import natemobiles.app.simpleyelpapiforandroid.models.YelpBusiness;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * YelpBusinessAdapter
 * @author nkemavaha
 *
 */
public class YelpBusinessAdapter extends ArrayAdapter<YelpBusiness> {

	/**
	 * Constructor
	 * @param context
	 * @param objects
	 */
	public YelpBusinessAdapter(Context context, List<YelpBusiness> objects) {
		super(context, 0, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater inflater = LayoutInflater.from(getContext());
			v = inflater.inflate(R.layout.item_result, null);
		}
		
		ImageView imgView = (ImageView) v.findViewById(R.id.ivImage);
		TextView headerView = (TextView) v.findViewById(R.id.tvHeader);
		TextView descView = (TextView) v.findViewById(R.id.tvDescription);
		TextView miscView = (TextView) v.findViewById(R.id.tvMisc);
		
		YelpBusiness item = getItem( position );
		// Loading image
		Picasso.with( getContext() ).load( item.getImageUrl() ).into( imgView );
		
		headerView.setText( item.getName() );
		descView.setText( item.getSnippetText() );
		miscView.setText( "Distance:" + Double.toString( item.getDistance() ) );
		
		return v;
	}
}
