package com.nehak.videoplayertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.nehak.videoplayertest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ExoPlayer player;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initializedPlayer();


    }

    private void initializedPlayer() {
        player = new ExoPlayer.Builder(this).build();
        binding.exo.setPlayer(player);

        MediaItem mediaItem = MediaItem.fromUri("https://media.chingari.io/uploads/0a093dda-e4bb-4533-a155-85b2e97b1c42-1604330367795/transcode/p480/0a093dda-e4bb-4533-a155-85b2e97b1c42-1604330367795.mp4");
        player.setMediaItem(mediaItem);
        player.prepare();
        player.play();
        player.setRepeatMode(Player.REPEAT_MODE_ONE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startPlayer();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void pausePlayer(){
        player.setPlayWhenReady(false);
        player.getPlaybackState();
    }
    private void startPlayer(){
        player.setPlayWhenReady(true);
        player.getPlaybackState();
    }
    @Override
    protected void onPause() {
        super.onPause();
        pausePlayer();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startPlayer();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (player.isPlaying()){
            player.stop();
        }
    }
}