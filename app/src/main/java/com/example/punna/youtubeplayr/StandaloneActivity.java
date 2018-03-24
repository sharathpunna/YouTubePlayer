package com.example.punna.youtubeplayr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

/**
 * Created by punna on 3/14/2018.
 */

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);

        Button btn1=(Button) findViewById(R.id.playvideo);
        Button btn2=(Button) findViewById(R.id.playlist);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent=null;

        switch (view.getId()){
            case R.id.playvideo:
                intent= YouTubeStandalonePlayer.createVideoIntent(this,YoutubeActivity.GOOGLE_API_KEY,YoutubeActivity.YOUTUBE_VIDEO_ID,0,true,true);
                break;
            case R.id.playlist:
                intent= YouTubeStandalonePlayer.createPlaylistIntent(this,YoutubeActivity.GOOGLE_API_KEY,YoutubeActivity.YOUTUBE_PLAYLIST);
                break;
            default:
        }
        if(intent!=null){
            startActivity(intent);
        }

    }
}
