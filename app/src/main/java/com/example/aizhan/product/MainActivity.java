package com.example.aizhan.product;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory,GestureDetector.OnGestureListener{

    private ImageSwitcher mImageSwitch;
    int position =0;
    private int[] mImageIds={R.drawable.abc,R.drawable.abc1,R.drawable.abc2,R.drawable.abc3};
    private GestureDetector mGestureDetector;
    private static final int SWIPE_MIN_DISTANCE=120;
    private static final int SWIPE_MAX_OFF_PATH=250;
    private static final int SWIPE_THRESHOLD_VELOCITY=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnImage();

        mImageSwitch=(ImageSwitcher)findViewById(R.id.imageSwitch);
        mImageSwitch.setFactory(this);

        for(int i=0;i<4;i++)
            mImageSwitch.setImageResource(mImageIds[i]);

        mGestureDetector=new GestureDetector(this,this);

        ImageView imageView1 = (ImageView) findViewById(R.id.imgView1);
        imageView1.setImageResource(R.drawable.abc);

        ImageView imageView2 = (ImageView) findViewById(R.id.imgView2);
        imageView2.setImageResource(R.drawable.abc);

        ImageView imageView3 = (ImageView) findViewById(R.id.imgView3);
        imageView3.setImageResource(R.drawable.abc);

        ImageView imageView4 = (ImageView) findViewById(R.id.imgView4);
        imageView4.setImageResource(R.drawable.abc);

        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setText(R.string.tittle_articul);

        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setText(R.string.tittle_ostatok);

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(R.string.tittle_scena);

        TextView textView3 = (TextView)findViewById(R.id.textView3);
        textView3.setText("545889648435");
        //textView3.setText(R.string.articul);

        TextView textView4 = (TextView)findViewById(R.id.textView4);
        textView4.setText("9989 шт");
        //textView4.setText(R.string.ostatok);

        TextView textView5 = (TextView)findViewById(R.id.textView5);
        textView5.setText("549 сом");
        //textView5.setText(R.string.scena);

        TextView textView6 = (TextView)findViewById(R.id.textView6);
        textView6.setText(R.string.kolichestvo);

        Button buttonS = (Button)findViewById(R.id.buttonS);
        buttonS.setText("S");

        Button buttonM = (Button)findViewById(R.id.buttonM);
        buttonM.setText("M");

        Button buttonL = (Button)findViewById(R.id.buttonL);
        buttonL.setText("L");

        Button buttonXL = (Button)findViewById(R.id.buttonXL);
        buttonXL.setText("XL");

        Button buttonXXL = (Button)findViewById(R.id.buttonXXL);
        buttonXXL.setText("XXL");

        Button buttonXXXL = (Button)findViewById(R.id.buttonXXXL);
        buttonXXXL.setText("XXXL");

        Button buttonXXXXL = (Button)findViewById(R.id.buttonXXXXL);
        buttonXXXXL.setText("XXXXL");

        Button buttonXXXXXL = (Button)findViewById(R.id.buttonXXXXXL);
        buttonXXXXXL.setText("XXXXXL");

        String[] size = {"S","M","L","XL","XXL","XXXL","XXXXL","XXXXXL"};
        //myButton.setEnabled(false);
    }

    public void addListenerOnImage(){
        mImageSwitch = (ImageSwitcher) findViewById(R.id.imageSwitch);
        mImageSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ImageActivity.class);
                startActivity(intent);
            }
        });
//        ImageView imageView1 = (ImageView) findViewById(R.id.imgView1);
//        imageView1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),ImageActivity.class);
//                startActivity(intent);
//            }
//        });
//        ImageView imageView2 = (ImageView) findViewById(R.id.imgView2);
//        imageView2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),ImageActivity.class);
//                startActivity(intent);
//            }
//        });
//        ImageView imageView3 = (ImageView) findViewById(R.id.imgView3);
//        imageView3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),ImageActivity.class);
//                startActivity(intent);
//            }
//        });
//        ImageView imageView4 = (ImageView) findViewById(R.id.imgView4);
//        imageView4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),ImageActivity.class);
//                startActivity(intent);
//            }
//        });
    }

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
        //imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
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
                mImageSwitch.setImageResource(mImageIds[position]);
            } else if (e2.getX() - e1.getX() > SWIPE_THRESHOLD_VELOCITY) {
                setPositionPrev();
                mImageSwitch.setImageResource(mImageIds[position]);
            }
        }
        catch(Exception e){
            return true;
        }
        return true;
    }
}
