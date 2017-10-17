package com.thea.beepproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    public final static int INTENT_RESULT = 1;
    public int currActivity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int isFirst = 1;




            switch(currActivity){

                case 0:
                    //holiday sprite
                    Intent intent = new Intent(this, VideoActivity.class);
                    String uriPath = "android.resource://com.thea.beepproject/" + R.raw.pcoa;
                    intent.putExtra("uriPath", uriPath);

                    startActivityForResult(intent, INTENT_RESULT);
                    break;

                case 1:
                case 3:
                    //promo vid
                    break;

                case 2:
                    //product
                    break;


            }
        Log.d("VideoActivity", "donesladfj");
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("VideoActivity", "checking curractivity");
        if (requestCode == 1) {
            if (resultCode == INTENT_RESULT) {

                if(currActivity < 3)
                    currActivity++;
                else
                    currActivity = 0;

                Log.d("VideoActivity", "adding curractivity" + currActivity);
            }
        }

    }
}
