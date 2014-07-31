package sus.gustaf.marketingdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Group_activity extends Activity {
	ListView grouplist;
	List<HashMap<String, String>> list_items;
	private static int[] group_member_photos = {
		R.drawable.face1, R.drawable.face2, R.drawable.face3, R.drawable.face4, R.drawable.face5
	};
	private static String[] group_member_names = {
		"Maxwell Homes", "Putin Ularjimir", "Max Carl", "Enstain Well", "Maria Dora"
	};
	private static String[] group_talk = {
		"How are you?", "Good morning?", "Wait", "Excellent", "See"
	};
	
	private static String[] group_member_evaluation = {
		"Excellent", "Best", "Elite", "Poor", "Weak"
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_group);
		grouplist = (ListView)findViewById(R.id.grop_items_list);
		list_items = new ArrayList<HashMap<String,String>>();
		for (int i = 0; i < 5; i ++) {
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("name", group_member_names[i]);
			hm.put("talk", group_talk[i]);
			hm.put("image", Integer.toString(group_member_photos[i]));
			hm.put("evaluation", group_member_evaluation[i]);
			list_items.add(hm);
		}
		String[] from = {"image", "name", "talk", "evaluation"};
		int[] to = { R.id.group_item_member, R.id.group_item_name, R.id.group_item_sign, R.id.group_item_evaluation };
		SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), list_items, R.layout.list_item_group, from, to);
		grouplist.setAdapter(adapter);
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
