package sus.gustaf.marketingdemo.adapters;

import java.util.ArrayList;

import sus.gustaf.marketingdemo.R;
import sus.gustaf.marketingdemo.elements.Goods_Item;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Goods_Adapter extends BaseAdapter {
	
	private Activity activity;
	private ArrayList<Goods_Item> data;
	private LayoutInflater inflater;
	public Goods_Adapter(Activity a, ArrayList<Goods_Item> d) {
		// TODO Auto-generated constructor stub
		activity = a;
		data = d;
		inflater = activity.getLayoutInflater();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return data.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		View vi = inflater.inflate(R.layout.list_item_goods, null);
		ImageView photo = (ImageView)vi.findViewById(R.id.list_items_picture);
		photo.setImageResource(data.get(arg0).goods_photo_id);
		TextView content = (TextView)vi.findViewById(R.id.list_items_content);
		content.setText(data.get(arg0).goods_content);
		return vi;
	}

}
