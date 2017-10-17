package com.thea.beepproject;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Log.d("VideoActivity", "Starting");

        Intent intent = getIntent();
        String uriPath = intent.getStringExtra("uriPath");
        Log.d("VideoActivity", "Got Path" + uriPath);

        VideoView mVideoView = (VideoView) findViewById(R.id.videoview);
        //String uriPath = "android.resource://com.thea.beepproject/" + R.raw.pcoa;
        Uri uri = Uri.parse(uriPath);
        mVideoView.setVideoURI(uri);
        mVideoView.requestFocus();
        mVideoView.start();
        Log.d("VideoActivity", "Playing");

        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            @Override
            public void onCompletion(MediaPlayer mp)
            {
                // Video Playing is completed
                Log.d("VideoActivity", "Done");
                Intent resultIntent = new Intent();
                setResult(MainActivity.INTENT_RESULT, resultIntent);
                finish();
            }
        });




    }
}
