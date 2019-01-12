package com.spirit.tech.lionortiger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void animation(View image)
    {
        ImageView animimage=(ImageView) image;

        animimage.setTranslationX(-2000);
        animimage.setImageResource(R.drawable.lion);
        animimage.animate().translationXBy(2000).rotation(2880).setDuration(2000);;
        
    }
}
