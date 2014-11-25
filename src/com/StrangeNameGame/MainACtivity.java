package com.StrangeNameGame;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.view.View;
import android.widget.LinearLayout;
import org.json.JSONArray;

import java.security.acl.LastOwnerException;

public class MainACtivity extends Activity {


    ImageView topLeft, topRight, botLeft, botRight;
    LinearLayout russianLettersTop,russianLettersBot;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();



    }

    /**
     * Initialize view elements
     */
    private void initView()
    {
        topLeft = (ImageView) findViewById(R.id.imageView1);

        topRight = (ImageView) findViewById(R.id.imageView2);

        botLeft = (ImageView) findViewById(R.id.imageView3);

        botRight = (ImageView) findViewById(R.id.imageView4);

        russianLettersTop = (LinearLayout) findViewById(R.id.russianLetters);
        russianLettersBot = (LinearLayout) findViewById(R.id.russianLetters2);
        for ( int i = 0; i < 5; i++ )
        {
            ImageView imageView = new ImageView(this);
            imageView.setPadding(0,0,0,0);
            imageView.setImageResource(R.drawable.twitter01);
            imageView.setLayoutParams(new ActionBar.LayoutParams(128,128));
            russianLettersTop.addView(imageView);

            ImageView imageViewBot = new ImageView(this);
            imageViewBot.setPadding(0,0,0,0);
            imageViewBot.setImageResource(R.drawable.twitter01);
            imageViewBot.setLayoutParams(new ActionBar.LayoutParams(128,128));
            russianLettersBot.addView(imageViewBot);
        }





    }
}
