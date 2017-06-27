package com.example.aizhan.product.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.aizhan.product.ImageActivity;
import com.example.aizhan.product.ModelObject;
import com.example.aizhan.product.R;
import com.github.chrisbanes.photoview.PhotoView;


public class CustomPagerAdapter extends PagerAdapter {
    private Context context;
    private ModelObject dataObjectList;
    private LayoutInflater layoutInflater;
    private PhotoView displayImage;
    private Boolean mainPage;
    public CustomPagerAdapter(Context context, ModelObject dataObjectList,Boolean mainPage){
        this.context = context;
        this.layoutInflater = (LayoutInflater)this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
        this.dataObjectList = dataObjectList;
        this.mainPage = mainPage;
    }
    @Override
    public int getCount() {
        return dataObjectList.getResId().length;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View)object);
    }
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = this.layoutInflater.inflate(R.layout.item_view_pager, container, false);
        displayImage = (PhotoView) view.findViewById(R.id.photo_view);
        displayImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mainPage) {
                    Intent intent = new Intent(context, ImageActivity.class);
                    intent.putExtra("resId", dataObjectList.getResId()[position]);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });
        Glide.with(context).load(dataObjectList.getResId()[position]).into(displayImage);
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}