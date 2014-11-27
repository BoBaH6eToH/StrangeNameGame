package com.StrangeNameGame;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.json.JSONArray;
import org.w3c.dom.Text;

import java.security.acl.LastOwnerException;
import java.util.Random;

public class MainACtivity extends Activity {


    ImageView topLeft, topRight, botLeft, botRight;
    LinearLayout russianLettersTop,russianLettersBot;
    String [] values;
    String secretWord;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Getting all words
        values = getResources().getStringArray(R.array.words);
        // Choosing secret word from string array
        secretWord = values[randInt(0,values.length - 1)];

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

        TextView titleText = (TextView) findViewById(R.id.titleText);
        titleText.setText(secretWord);


        secretWord = "тураль";

        for ( int i = 0; i < secretWord.length(); i++ )
        {
            ImageView imageView = new ImageView(this);

            int diff = secretWord.charAt(i) - 'а';

            String fnm = "letter" + String.valueOf(diff+1); //  this is image file name
            String PACKAGE_NAME = getApplicationContext().getPackageName();
            int imgId = getResources().getIdentifier(PACKAGE_NAME+":drawable/"+fnm , null, null);
            imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), imgId));

            imageView.setLayoutParams(new ActionBar.LayoutParams(128, 128));
            russianLettersTop.addView(imageView);
        }





    }

    /**
     * Generate random integer number in [min;max]
     * @param min
     * @param max
     * @return random value in the interval
     */
    private static int randInt(int min, int max)
    {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
