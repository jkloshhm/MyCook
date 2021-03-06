package com.example.guojian.weekcook.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.guojian.weekcook.R;
import com.example.guojian.weekcook.utils.GetBitmapFromSdCardUtil;

public class MyHeadImageShowerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_head_image_shower);
        LinearLayout mMyHeadImage = (LinearLayout) findViewById(R.id.ll_my_header_image_shower);
        ImageView imageView = (ImageView) findViewById(R.id.iv_my_header_image_shower);
        if (mMyHeadImage != null) {
            mMyHeadImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
        if (GetBitmapFromSdCardUtil.hasSdcard()) {
            String path = Environment.getExternalStorageDirectory() + "/Cooking/myHeadImg/";// sd路径
            Bitmap bt = GetBitmapFromSdCardUtil.getBitmap(path + "head.jpg");
            if (bt != null) {
                @SuppressWarnings("deprecation")
                Drawable drawable = new BitmapDrawable(bt);
                if (imageView != null) {
                    imageView.setImageDrawable(drawable);
                }
                if (bt.isRecycled()) {
                    bt.recycle();
                }
            }
        }
    }


}
