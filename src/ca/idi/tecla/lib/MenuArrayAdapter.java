package ca.idi.tecla.lib;

import com.microcontrollerbg.irdroid.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
 
public class MenuArrayAdapter extends ArrayAdapter<String> {

	private Context context;
	private String[] values;
	private Drawable[] imageResource;
	
	public MenuArrayAdapter(Context context, String[] objects, Drawable[] imagelist) {
		super(context, 0, objects);
		this.context = context;
		this.values = objects;
		this.imageResource = imagelist;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LinearLayout layout = new LinearLayout(context);
//		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
//		layout.setLayoutParams(params);
		layout.setPadding(5, 5, 5, 5);
		layout.setOrientation(LinearLayout.VERTICAL);
		
		ImageView imageView = new ImageView(context);
		imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon));
		LayoutParams image_params = new LayoutParams(50, 50, Gravity.CENTER);
		image_params.setMargins(0, 5, 0, 0);
		image_params.gravity = Gravity.CENTER;
		imageView.setLayoutParams(image_params);
		layout.addView(imageView);
		
		TextView textView = new TextView(context);
		textView.setLines(1);
		textView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, android.view.ViewGroup.LayoutParams.FILL_PARENT));
		textView.setGravity(Gravity.CENTER);
		textView.setTextAppearance(getContext(), android.R.attr.textAppearanceMedium);
		layout.addView(textView);
		
		if(imageResource[position] == null){
			imageView.setVisibility(View.GONE);
			textView.setHeight(textView.getHeight() + 55);
		}
		textView.setText(values[position]);
		imageView.setImageDrawable(imageResource[position]);
		return layout;
	}
}