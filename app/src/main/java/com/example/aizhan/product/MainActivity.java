package com.example.aizhan.product;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aizhan.product.adapter.CustomPagerAdapter;
import com.example.aizhan.product.adapter.PageTransformer;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private int[] mResId ={R.drawable.abc,R.drawable.abc1,R.drawable.abc2,R.drawable.abc3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this,new ModelObject(mResId)));
        viewPager.setPageTransformer(true,new PageTransformer());
        gavnoKodOtAijan();


    }

    public void gavnoKodOtAijan(){
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


}
