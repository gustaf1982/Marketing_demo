package sus.gustaf.marketingdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Favorite extends Activity {
	ListView favoritelist;
	List<HashMap<String, String>> list_items;
	private static int[] goods_photo_ids = {
		R.drawable.adidas_shoes, R.drawable.popular_sandal, R.drawable.rock_sandal, R.drawable.women_dress_shoe,
		R.drawable.lolita_women_s_shoes, R.drawable.gothic_punk, R.drawable.high_heel_shoe, R.drawable.safety_shoe,
		R.drawable.latest_shoes, R.drawable.fashion_shoe
	};
	private static String[] goods_names = {
		"adidas_shoes", "popular_sandal", "rock_sandal", "women_dress_shoe", "lolita_women_shoe", 
		"gothic_punk", "high_heel_shoe", "safety_shoe", "latest_shoe", "fashion_shoe"
	};
	private static int[] goods_cost = {
		16, 20, 35, 65, 30, 50, 45, 33, 57, 35
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_favorite);
		favoritelist = (ListView)findViewById(R.id.favorite_list_items);
		list_items = new ArrayList<HashMap<String,String>>();
		for (int i = 0; i < 10; i ++) {
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("name", goods_names[i]);
			hm.put("price", "Price : "+ Integer.toString(goods_cost[i]));
			hm.put("image", Integer.toString(goods_photo_ids[i]));
			hm.put("amount", "Amounts : 6");
			list_items.add(hm);
		}
		String[] from = {"image", "name", "amount", "price"};
		int[] to = { R.id.favorite_item_photo, R.id.favorite_item_name, R.id.favorite_item_quantity, R.id.favorite_item_price };
		SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), list_items, R.layout.list_item_favorite, from, to);
		favoritelist.setAdapter(adapter);
		setActionBar();
	}
	private void setActionBar() {
		// TODO Auto-generated method stub
		ImageView btn_leftaction = (ImageView)findViewById(R.id.btn_leftaction);
		TextView title = (TextView)findViewById(R.id.title_text);
		title.setText("Favorite");
		ImageView btn_rightaction = (ImageView)findViewById(R.id.btn_rightaction);
		btn_leftaction.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		btn_rightaction.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.e("aaaaaaaaaaa", "aaaaaaaaaaa");
			}
		});
	}
}
