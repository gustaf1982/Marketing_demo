package sus.gustaf.marketingdemo;





import sus.gustaf.marketingdemo.ui.MainView;
import sus.gustaf.marketingdemo.ui.MainView.OnTurnplateListener;
import sus.gustaf.marketingdemo.ui.MainView.Point;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
@SuppressLint("NewApi")
public class MainActivity extends ActionBarActivity implements OnTurnplateListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int height = getWindowManager().getDefaultDisplay().getHeight();
		int width = getWindowManager().getDefaultDisplay().getWidth();
		getWindow().setBackgroundDrawableResource(R.drawable.costdown);
		Log.e(String.valueOf(width), String.valueOf(height));		
		MainView myView = new MainView(this, width/2, height/2, width/3+30);
		myView.setOnTurnplateListener(this);
		setContentView(myView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onPointTouch(Point point) {
		// TODO Auto-generated method stub
		int flag = point.flag;
		Intent intent = new Intent();
		switch (flag)
		{
			case 0:
				intent.setClass(this, Sign_activity.class);
				this.startActivity(intent);
				break;
			case 1:
				intent.setClass(this, IntroMyCompany.class);
				intent.putExtra("flag",0);
				this.startActivity(intent);
				break;
			case 2:
				intent.setClass(this, Goods.class);
				this.startActivity(intent);
				break;
			case 3:
				
				intent.setClass(this, Group_activity.class);
				this.startActivity(intent);
				break;
			case 4:
				intent.setClass(this, Bussiness_activity.class);
				this.startActivity(intent);
				break;
			case 5:
				intent.setClass(this, IntroMyCompany.class);
				intent.putExtra("flag",1);
				this.startActivity(intent);
				break;
			case 6:
				intent.setClass(this, SendMail.class);
				this.startActivity(intent);
				break;
			case 7:			
				intent.setClass(this, Favorite.class);
				this.startActivity(intent);
				break;			
			default:
				break;
		}
	}
}
