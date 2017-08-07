package com.mahrus.bantuaku.mahrusdraw;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaDescription;
import android.os.Bundle;
import android.widget.ImageView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;


public class MakananActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan);

       /* *//*TextDrawable drawable = TextDrawable.builder()
                .buildRoundRect("A", Color.YELLOW, 0);

        TextDrawable.IBuilder builder = TextDrawable.builder()
                .beginConfig()
                .withBorder(4)
                .endConfig()
                .rect();

        ImageView image = (ImageView) findViewById(R.id.image_view);*//*
        image.setImageDrawable(drawable);*/



        TextDrawable drawable1 = TextDrawable.builder()
                .buildRoundRect("A", Color.YELLOW, 0);

        ImageView image1 = (ImageView) findViewById(R.id.imageview);
        image1.setImageDrawable(drawable1);
    }
}
