package com.example.mahfujislam.wordlistv20;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ToggleButton;


public class activity_learning extends ActionBarActivity implements Animation.AnimationListener{
    TextView tx_value , tx_meaning ;
    ToggleButton bt_hide_show ;
    Animation animFadeIn , animFadeOut ;
    String ON = "Show" , OFF = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_learning);

        bt_hide_show = (ToggleButton)findViewById(R.id.bt_hide_show);

        tx_meaning = (TextView)findViewById(R.id.tx_meaning);
        tx_meaning.setVisibility(View.INVISIBLE);

        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        animFadeOut= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);

        animFadeIn.setAnimationListener(this);
        animFadeOut.setAnimationListener(this);


        bt_hide_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder str = new StringBuilder();
                str.append(bt_hide_show.getText());
                if("Show".equalsIgnoreCase(str.toString())){
                    tx_meaning.setVisibility(View.INVISIBLE);
                    tx_meaning.startAnimation(animFadeOut);
                }
                else if("Hide".equalsIgnoreCase(str.toString())){
                    tx_meaning.setVisibility(View.VISIBLE);
                    tx_meaning.startAnimation(animFadeIn);

                }
            }
        });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_learning, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
