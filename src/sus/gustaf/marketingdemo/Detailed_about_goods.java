package sus.gustaf.marketingdemo;

import sus.gustaf.marketingdemo.elements.Goods_Item;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detailed_about_goods extends Activity implements OnClickListener{
	private Goods_Item goods_item;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_detailed);
		setActionBar();
		Intent receive = getIntent();		
		int photoid = receive.getIntExtra("photoid", R.drawable.gothic_punk);
		String name = receive.getStringExtra("name");
		String content = receive.getStringExtra("content");
		int price = receive.getIntExtra("price", 0);
		//goods_item = Goods.getreference().getGoods(index);
		setMainScreen(photoid, name, content, price);
	}
	private void setActionBar() {
		// TODO Auto-generated method stub
		ImageView btn_leftaction = (ImageView)findViewById(R.id.btn_leftaction);
		TextView title = (TextView)findViewById(R.id.title_text);
		title.setText("Detail");
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

	private void setMainScreen(int photoid, String name, String content, int price) {
		// TODO Auto-generated method stub
		ImageView goods_photo = (ImageView)findViewById(R.id.detail_goods_photo);
		goods_photo.setImageResource(photoid);
		TextView goods_name = (TextView)findViewById(R.id.detail_goods_name);
		goods_name.setText("name:"+name);
		TextView goods_price = (TextView)findViewById(R.id.detail_goods_price);
		goods_price.setText("price:"+String.valueOf(price));
		Button btn_cart = (Button)findViewById(R.id.detail_cart);
		btn_cart.setOnClickListener(this);
		Button btn_favorite = (Button)findViewById(R.id.detail_favorite);
		btn_favorite.setOnClickListener(this);
		Button btn_service = (Button)findViewById(R.id.detail_service_after);
		btn_service.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.detail_cart:
			
			break;

		case R.id.detail_favorite:
			
			break;
		case R.id.detail_service_after:
			
			break;
		
		}
	}
}
