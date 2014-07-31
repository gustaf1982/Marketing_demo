package sus.gustaf.marketingdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IntroMyCompany extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		setActionBar();
		Intent getfromprevious = getIntent();
		int flag = getfromprevious.getIntExtra("flag", 0);
		Log.e(String.valueOf(flag), "aaaaaaaaa");
		TextView content_us = (TextView)findViewById(R.id.about_company);
		LinearLayout phone_state = (LinearLayout)findViewById(R.id.phone_dialoge);
		if (flag == 0) {
			content_us.setVisibility(View.VISIBLE);
			phone_state.setVisibility(View.GONE);
		} else {
			content_us.setVisibility(View.GONE);
			phone_state.setVisibility(View.VISIBLE);
			setPhoneAction();	
		}
	}

	private void setActionBar() {
		// TODO Auto-generated method stub
		ImageView btn_leftaction = (ImageView)findViewById(R.id.btn_leftaction);
		TextView title = (TextView)findViewById(R.id.title_text);
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

	private void setPhoneAction() {
		// TODO Auto-generated method stub
		Log.e("aaaaaaaaaaa", "aaaaaaaaaaa");
		ImageView btn_call = (ImageView)findViewById(R.id.btn_call);
		btn_call.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.e("aaaaaaaaaaa", "aaaaaaaaaaa");
			}
		});
		Button btn_online = (Button)findViewById(R.id.btn_online_call);
		btn_online.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.e("aaaaaaaaaaa", "aaaaaaaaaaa");
			}
		});
	}
}
