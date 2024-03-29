package com.patrickbanez.workoutapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private View view;
    private Button btn;
    private ProfileFragment profile;

    public HomeFragment() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    ImageButton play_button;
    ImageButton pause_button;
    MediaPlayer mediaPlayer;
    ImageButton exercise_button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        play_button = (ImageButton) view.findViewById(R.id.play_button);
        pause_button = (ImageButton) view.findViewById(R.id.pause_button);
        exercise_button = (ImageButton) view.findViewById(R.id.exercise_button);
        exercise_button.setOnClickListener(view13 -> {
            Intent intent = new Intent(getContext(), CreateUserActivity.class);
            startActivity(intent);
        });


        play_button.setOnClickListener(view1 -> {
            mediaPlayer = MediaPlayer.create(getContext(),R.raw.music);
            mediaPlayer.start();
        });

        pause_button.setOnClickListener(view12 -> {
            if(mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.reset();
            }
        });
        return view;
    }
}