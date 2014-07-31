package sus.gustaf.marketingdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Bussiness_activity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_bussiness);
		setActionBar();
	}

	private void setActionBar() {
		// TODO Auto-generated method stub
		ImageView btn_leftaction = (ImageView)findViewById(R.id.btn_leftaction);
		TextView title = (TextView)findViewById(R.id.title_text);
		title.setText("Bussiness");
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
