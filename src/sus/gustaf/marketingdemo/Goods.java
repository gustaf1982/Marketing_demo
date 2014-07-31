package sus.gustaf.marketingdemo;

import java.util.ArrayList;

import sus.gustaf.marketingdemo.adapters.Goods_Adapter;
import sus.gustaf.marketingdemo.elements.Goods_Item;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Goods extends Activity {

	//Goods Referenceofme;
	//public static Goods getreference() {
		//Goods me = new Goods();
		//return me;
	//}
	ListView goodslist;
	ArrayList<Goods_Item> items;
	Goods_Adapter adapter;
	Intent intent_goods;
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
	private static String[] goods_contents = {
		"FOB Price:US$30-60/Pair" + "\nMin.Order Quantity:10 Pair/Pairs" + "\nSupply Ability:1500 Pair/Pairs per Month","FOB Price:US$30-60/Pair"+"\nMin.Order Quantity:10 Pair/Pairs"+"\nPayment Terms:T/T,PayPal",
		"FOB Price:US$60-90/Pair"+"\nMin.Order Quantity:10 Pair/Pairs"+"\nSupply Ability:1500 Pair/Pairs per Month"+"\nPayment Terms:T/T,PayPal","FOB Price:US$30-60/Pair"+"\nSupply Ability:1500 Pair/Pairs per Month"+"\nPayment Terms:T/T,PayPal",
		"FOB Price:US$30-60/Pair"+"\nMin.Order Quantity:10 Pair/Pairs"+"\nSupply Ability:1500 Pair/Pairs per Month","FOB Price:US$30-60/Pair "+"\nMin.Order Quantity:10 Pair/Pairs "+"\nPayment Terms:T/T,PayPal",
		"FOB Price:US$60-90/Pair "+"\nMin.Order Quantity:10 Pair/Pairs "+"\nSupply Ability:1500 Pair/Pairs per Month "+"\nPayment Terms:T/T,PayPal","FOB Price:US$30-60/Pair "+"\nSupply Ability:1500 Pair/Pairs per Month "+"\nPayment Terms:T/T,PayPal",
		"FOB Price:US$30-60/Pair "+"\nMin.Order Quantity:10 Pair/Pairs "+"\nSupply Ability:1500 Pair/Pairs per Month","FOB Price:US$60-90/Pair "+"\nMin.Order Quantity:10 Pair/Pairs "+"\nSupply Ability:1500 Pair/Pairs per Month "+"\nPayment Terms:T/T,PayPal"
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_goods);
		setActionBar();
		intent_goods = new Intent();
		goodslist = (ListView)findViewById(R.id.goods_list);
		items = new ArrayList<Goods_Item>();
		for (int i = 0; i < 10; i ++) {
			Goods_Item item = new Goods_Item(goods_photo_ids[i], goods_names[i], goods_contents[i], goods_cost[i]);
			items.add(item);
		}
		adapter = new Goods_Adapter(Goods.this, items);
		goodslist.setAdapter(adapter);
		goodslist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				intent_goods.setClass(Goods.this, Detailed_about_goods.class);
				intent_goods.putExtra("name", items.get(arg2).goods_name);
				intent_goods.putExtra("photoid", items.get(arg2).goods_photo_id);
				intent_goods.putExtra("content", items.get(arg2).goods_content);
				intent_goods.putExtra("price", items.get(arg2).goods_price);
				startActivity(intent_goods);				
			}
		});
	}
	private void setActionBar() {
		// TODO Auto-generated method stub
		ImageView btn_leftaction = (ImageView)findViewById(R.id.btn_leftaction);
		TextView title = (TextView)findViewById(R.id.title_text);
		title.setText("Goods");
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

	//public Goods_Item getGoods(int _index) {
		//return items.get(_index);
	//}
	
}
