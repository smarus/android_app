package com.example.aizhan.product;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

public class ImageActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory, GestureDetector.OnGestureListener{

    private ImageSwitcher mImageSwitcher;
    int position =0;
    private int[] mImageIds={R.drawable.abc,R.drawable.abc1,R.drawable.abc2,R.drawable.abc3};
    private GestureDetector mGestureDetector;
    private static final int SWIPE_MIN_DISTANCE=120;
    private static final int SWIPE_MAX_OFF_PATH=250;
    private static final int SWIPE_THRESHOLD_VELOCITY=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        //        requestWindowFeature( Window.FEATURE_NO_TITLE );
//        setContentView( R.layout.main );
//        getWindow().addFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN );
//        selectRandomImage();

        mImageSwitcher=(ImageSwitcher)findViewById(R.id.imageSwitcher);
        mImageSwitcher.setFactory(this);

        for(int i=0;i<4;i++)
            mImageSwitcher.setImageResource(mImageIds[i]);

        mGestureDetector=new GestureDetector(this,this);
    }

//    @Override
//    public void onContentChanged()
//    {
//        super.onContentChanged();
//        mImageSwitcher = (ImageSwitcherTouch)findViewById( R.id.imageSwitcher);
//    }

    public void setPositionNext(){
        position++;
        if(position>mImageIds.length-1){
            position=0;
        }
    }

    public void setPositionPrev(){
        position--;
        if(position<0){
            position=mImageIds.length-1;
        }
    }

    @Override
    public View makeView(){
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        return imageView;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        return mGestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e){
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e){}

    @Override
    public boolean onSingleTapUp(MotionEvent e){
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e){}

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2,float velocityX, float velocityY){
        try {
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                return false;
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                setPositionNext();
                mImageSwitcher.setImageResource(mImageIds[position]);
            } else if (e2.getX() - e1.getX() > SWIPE_THRESHOLD_VELOCITY) {
                setPositionPrev();
                mImageSwitcher.setImageResource(mImageIds[position]);
            }
        }
        catch(Exception e){
            return true;
        }
        return true;
    }
}
