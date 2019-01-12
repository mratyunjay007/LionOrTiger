package com.spirit.tech.lionortiger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    enum Player
    {
        ONE,TWO
    }

    Player currentuser=Player.ONE;
    Player [] playerchoices=new Player[9];

    int [][] select={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void animation(View image)
    {
        ImageView animimage=(ImageView) image;

        int titag=Integer.parseInt(image.getTag().toString());

        if(playerchoices[titag]==null){

        playerchoices[titag]=currentuser;

        animimage.setTranslationX(-2000);

        if(currentuser==Player.ONE) {
            currentuser=Player.TWO;
            animimage.setImageResource(R.drawable.lion);
        }
        else if(currentuser==Player.TWO) {
            currentuser=Player.ONE;
            animimage.setImageResource(R.drawable.tiger);
        }
        animimage.animate().alpha(1).translationXBy(2000).rotation(2880).setDuration(500);

        for(int [] winner: select)
        {
            if(playerchoices[winner[0]]==playerchoices[winner[1]] && playerchoices[winner[1]]==playerchoices[winner[2]]
                    && playerchoices[winner[0]]!=null){

                String win="";
                if(currentuser==Player.TWO)
                {
                    win="First";
                }
                else if(currentuser==Player.ONE)
                {
                    win="Second";
                }
                Toast.makeText(MainActivity.this,win+" User wins",Toast.LENGTH_LONG).show();
            }
        }

    }
    }


}
