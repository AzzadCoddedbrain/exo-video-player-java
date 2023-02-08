package com.nehak.videoplayertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.StyledPlayerView;

public class MainActivity extends AppCompatActivity {

    StyledPlayerView playerView;
    ExoPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerView = findViewById(R.id.exo);

    }

    private void initializedPlayer() {
        player = new ExoPlayer.Builder(this).build();
        playerView.setPlayer(player);

        MediaItem mediaItem = MediaItem.fromUri("https://media.chingari.io/uploads/f8067cd6-999c-4dd4-a464-9ccd49ba724a-1658035840001/webpath_f8067cd6-999c-4dd4-a464-9ccd49ba724a-1658035840001.mp4");
        player.setMediaItem(mediaItem);
        player.prepare();
        player.play();

    }

    @Override
    protected void onStart() {
        super.onStart();
        initializedPlayer();

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player==null){
            initializedPlayer();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (player.isPlaying()){
            player.stop();
        }
    }
}