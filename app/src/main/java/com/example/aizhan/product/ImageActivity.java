package com.example.aizhan.product;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageActivity extends AppCompatActivity {

    ImageView choosenImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        choosenImage = (ImageView)findViewById(R.id.image_full_screen);
        int resId = getIntent().getIntExtra("resId",R.drawable.abc);
        Glide.with(this).load(resId).into(choosenImage);
    }
}