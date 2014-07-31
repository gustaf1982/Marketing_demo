package sus.gustaf.marketingdemo.ui;



import sus.gustaf.marketingdemo.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MainView extends View implements OnTouchListener{

	private Paint mPaint = new Paint();	
	private Paint paintCircle =  new Paint();	
	private Bitmap[] icons = new Bitmap[8];	
	private Point[] points;	
	private static final int PONIT_NUM = 8;
	
	
	private int mPointX=0, mPointY=0;	
	private int mRadius = 0;	
	private int mDegreeDelta;	
	private int tempDegree = 0;	
	private int chooseBtn=999;
	private Matrix mMatrix = new Matrix();  
	private OnTurnplateListener onTurnplateListener;
	public void setOnTurnplateListener(OnTurnplateListener onTurnplateListener) {
		this.onTurnplateListener = onTurnplateListener;
	}
	public MainView(Context context, int px, int py, int radius) {
		super(context);
		mPaint.setColor(Color.RED);
		mPaint.setStrokeWidth(2);
		paintCircle.setAntiAlias(true);
		paintCircle.setColor(Color.WHITE);
		loadIcons();
		mPointX = px;
		mPointY = py;
		mRadius = radius;		
		initPoints();
		importscale();
	}

	private void importscale() {
		// TODO Auto-generated method stub
		Point point;
		for(int index=0; index<PONIT_NUM; index++) {
			point = points[index];
			point.x = mPointX+ (float)(mRadius * Math.cos(point.angle*Math.PI/180));
			point.y = mPointY+ (float)(mRadius * Math.sin(point.angle*Math.PI/180));	
			point.x_c = mPointX+(point.x-mPointX)/2;
			point.y_c = mPointY+(point.y-mPointY)/2;
		}
	}
	private void initPoints() {
		// TODO Auto-generated method stub
		points = new Point[PONIT_NUM];
		Point point;
		int angle = 0;
		mDegreeDelta =360/PONIT_NUM;		
		for(int index=0; index<PONIT_NUM; index++) {
			point = new Point();
			point.angle = angle;
			angle += mDegreeDelta;
			point.bitmap = icons[index];
			point.flag=index;
			points[index] = point;		
		}
	}
	private void loadIcons() {
		// TODO Auto-generated method stub
		Resources r = getResources();
		loadBitmaps(0, r.getDrawable(R.drawable.club));
		loadBitmaps(1, r.getDrawable(R.drawable.information));
		loadBitmaps(2, r.getDrawable(R.drawable.product));
		loadBitmaps(3, r.getDrawable(R.drawable.member));
		loadBitmaps(4, r.getDrawable(R.drawable.business));
		loadBitmaps(6, r.getDrawable(R.drawable.message));
		loadBitmaps(5, r.getDrawable(R.drawable.telephone));
		loadBitmaps(7, r.getDrawable(R.drawable.order));
	}
	private void loadBitmaps(int index, Drawable dr) {
		// TODO Auto-generated method stub
		Bitmap bitmap = Bitmap.createBitmap(60,60,Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		dr.setBounds(0, 0, 60, 60);
		dr.draw(canvas);
		icons[index]=bitmap;
	}
	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int action = event.getAction();
        switch (action) {
        case MotionEvent.ACTION_DOWN:
            break;
        case MotionEvent.ACTION_MOVE:
        	resetPointAngle(event.getX(), event.getY());
        	importscale();
    		invalidate();
            break;
        case MotionEvent.ACTION_UP:
        	switchScreen(event);
        	tempDegree = 0;
        	invalidate();
            break;
        case MotionEvent.ACTION_CANCEL:	        	
            break;
        }
        return true;
	}
	private void switchScreen(MotionEvent event) {
		// TODO Auto-generated method stub
		computeCurrentDistance(event.getX(), event.getY());
		for(Point point:points){
			if(point.isCheck)
			{
				onTurnplateListener.onPointTouch(point);
				break;
			}
		}	
	}
	private void computeCurrentDistance(float x, float y) {
		// TODO Auto-generated method stub
		for(Point point:points){
			float distance = (float)Math.sqrt(((x-point.x)*(x-point.x) + (y-point.y)*(y-point.y)));			
			if(distance<31){
				chooseBtn = 999;
				point.isCheck = true;
				break;
			}else{
				point.isCheck = false;
				chooseBtn =  point.flag;
			}
		}	
	}
	private void resetPointAngle(float x, float y) {
		// TODO Auto-generated method stub
		int degree = computeMigrationAngle(x, y);
		for(int index=0; index<PONIT_NUM; index++) {			
			points[index].angle += degree;		
			if(points[index].angle>360){
				points[index].angle -=360;
			}else if(points[index].angle<0){
				points[index].angle +=360;
			}			
		}
	}
	private int computeMigrationAngle(float x, float y) {
		// TODO Auto-generated method stub
		int a=0;
		float distance = (float)Math.sqrt(((x-mPointX)*(x-mPointX) + (y-mPointY)*(y-mPointY)));
		int degree = (int)(Math.acos((x-mPointX)/distance)*180/Math.PI);
		if(y < mPointY) {
			degree = -degree;
		}	
		if(tempDegree!=0){
			a = degree - tempDegree;
		}
		tempDegree=degree;		
		return a;
	}
	public static interface OnTurnplateListener {
	       
	     public void onPointTouch(Point point);
	       	             	        
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		Paint paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setTextSize(50.0f * mPointX / 360);
 		canvas.drawText("I DO COPORATION CO.,LTD", 60 * mPointX / 360, 150 * mPointX / 360, paint);
		Bitmap bitmap = ((BitmapDrawable)(getResources().getDrawable(R.drawable.circle_bg))).getBitmap();
		Bitmap girlBitmap = ((BitmapDrawable)(getResources().getDrawable(R.drawable.girl))).getBitmap();
		canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(mPointX- mRadius-40, mPointY-mRadius-40, 
				mPointX + mRadius+40, mPointY + mRadius+40), null);
		canvas.drawBitmap(girlBitmap, new Rect(0, 0, girlBitmap.getWidth(), girlBitmap.getHeight()), new Rect(mPointX- mRadius+60, mPointY-mRadius+60, 
				mPointX + mRadius-60, mPointY + mRadius-52), null);
		//canvas.drawBitmap(bitmap, mPointX- bitmap.getWidth()/2, mPointY-bitmap.getHeight()/2, null);
		//canvas.drawBitmap(girlBitmap, mPointX- girlBitmap.getWidth()/2, mPointY-girlBitmap.getHeight()/2, null);
		for(int index=0; index<PONIT_NUM; index++) {	
			drawInCenter(canvas, points[index].bitmap, points[index].x, points[index].y,points[index].flag);
		}
	}
	private void drawInCenter(Canvas canvas, Bitmap bitmap, float left, float top,
			int index) {
		// TODO Auto-generated method stub
		canvas.drawPoint(left, top, mPaint);
		if(chooseBtn==index){			
			mMatrix.setScale(70f/bitmap.getWidth(), 70f/bitmap.getHeight());   
			mMatrix.postTranslate(left-35, top-35);  
			canvas.drawBitmap(bitmap, mMatrix, null); 
		}else{
			canvas.drawBitmap(bitmap, left-bitmap.getWidth()/2, top-bitmap.getHeight()/2, null);
		}	
	}
	public class Point {		
		public int flag;		
		Bitmap bitmap;		
		int angle;		
		float x;		
		float y;		
		float x_c;		
		float y_c;		
		boolean isCheck;
	}
	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		return false;
	}
}
