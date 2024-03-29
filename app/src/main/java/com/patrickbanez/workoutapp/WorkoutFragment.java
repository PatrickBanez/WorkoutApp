package com.patrickbanez.workoutapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WorkoutFragment#getInstance} factory method to
 * retrieve an instance of this fragment.
 */
public class WorkoutFragment extends Fragment {
    private static WorkoutFragment instance;

    public WorkoutFragment() {
        // Required empty public constructor
        instance = this;
    }

    public static WorkoutFragment getInstance() {
        if(instance == null) {
            instance = new WorkoutFragment();
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout, container, false);
    }
}