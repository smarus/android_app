package com.example.aizhan.product;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.aizhan.product.adapter.CustomPagerAdapter;
import com.example.aizhan.product.adapter.PageTransformer;

public class ImageActivity extends AppCompatActivity {

    ViewPager viewPager;
    private int[] mResId ={R.drawable.abc,R.drawable.abc1,R.drawable.abc2,R.drawable.abc3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        viewPager = (ViewPager) findViewById(R.id.inner_view_pager);
        int resId = getIntent().getIntExtra("resId",R.drawable.abc);
        //Glide.with(this).load(resId).into(choosenImage);
        viewPager.setAdapter(new CustomPagerAdapter(this,new ModelObject(mResId),false));
        viewPager.setPageTransformer(true,new PageTransformer());

    }
}