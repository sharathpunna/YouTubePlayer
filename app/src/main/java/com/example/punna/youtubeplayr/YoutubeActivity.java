package com.example.punna.youtubeplayr;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener{
    private static final String TAG = "YoutubeActivity";
    static final String GOOGLE_API_KEY="AIzaSyDZ976ZeDRIwuNxVYQr8GVDK0Zme1dctKk";
    static final String YOUTUBE_VIDEO_ID="ElpitAfkRS4";
    static final String YOUTUBE_PLAYLIST="PLXtTjtWmQhg1SsviTmKkWO5n0a_-T0bnD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        ConstraintLayout layout=(ConstraintLayout) findViewById(R.id.activity_youtube);

        YouTubePlayerView playerView=new YouTubePlayerView(this);
        playerView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        layout.addView(playerView);
        playerView.initialize(GOOGLE_API_KEY,this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasrestored) {
        Log.d(TAG, "onInitializationSuccess: provider is"+ provider.getClass().toString());
        Toast.makeText(this,"Initialised successfully",Toast.LENGTH_LONG).show();

        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);

        if(!wasrestored){
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        final int REQUEST_CODE=1;
        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,REQUEST_CODE).show();
        }else {
            String errorMessage=String.format("there was an error in operating (%1$s)",youTubeInitializationResult.toString());
            Toast.makeText(this,errorMessage,Toast.LENGTH_LONG).show();
        }
    }
    private YouTubePlayer.PlaybackEventListener playbackEventListener=new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {
            Toast.makeText(YoutubeActivity.this, "video is playing", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPaused() {
            Toast.makeText(YoutubeActivity.this, "video is paused", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStopped() {
            Toast.makeText(YoutubeActivity.this, "video is stopped", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onBuffering(boolean b) {
        }

        @Override
        public void onSeekTo(int i) {

        }
    };
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener=new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {
            Toast.makeText(YoutubeActivity.this, "Breathe in,Breathe out", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onLoaded(String s) {
            Toast.makeText(YoutubeActivity.this, "There u go", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onAdStarted() {
            Toast.makeText(YoutubeActivity.this, "click,make creater richer", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {
            Toast.makeText(YoutubeActivity.this, "THE END", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };

}
