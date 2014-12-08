package com.StrangeNameGame;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        pushImages(1);


    }
    /**
     * Inserting images
     */
    private void pushImages(int index)
    {
        Short countMas = 4;
        String PACKAGE_NAME = getApplicationContext().getPackageName();

        for (int i = 1; i < countMas + 1; i++)
        {
            String path = "image" + String.valueOf(index) + "_" + String.valueOf(i);
            int imgId = getResources().getIdentifier(PACKAGE_NAME+":drawable/"+path , null, null);
            if (i == 1)
            {
                topLeft.setPadding(10, 10, 10, 10);
                topLeft.setImageBitmap(BitmapFactory.decodeResource(getResources(), imgId));
            }
            if (i == 2)
            {
                topRight.setPadding(10, 10, 10, 10);
                topRight.setImageBitmap(BitmapFactory.decodeResource(getResources(), imgId));
            }
            if (i == 3)
            {
                botLeft.setPadding(10, 10, 10, 10);
                botLeft.setImageBitmap(BitmapFactory.decodeResource(getResources(), imgId));
            }
            if (i == 4)
            {
                botRight.setPadding(10, 10, 10, 10);
                botRight.setImageBitmap(BitmapFactory.decodeResource(getResources(), imgId));
            }
        }
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
