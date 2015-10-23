package com.example.flaggame;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Михайлик on 22.10.2015.
 */
public class FindOut extends Activity {

    private TextView vCountry;
    private TextView vInform;
    private ImageView vFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        vCountry = (TextView) findViewById(R.id.activity_country);
        vInform = (TextView) findViewById(R.id.activity_country_text);
        vFlag = (ImageView) findViewById(R.id.activity_flag_imageView);

        vCountry.setText(getIntent().getIntExtra(FlagActivity.EXTRA_COUNTRY,0));
        vInform.setText(getIntent().getIntExtra(FlagActivity.EXTRA_ANSWER,0));
        vFlag.setImageResource(getIntent().getIntExtra(FlagActivity.EXTRA_FLAG,0));
    }
}
