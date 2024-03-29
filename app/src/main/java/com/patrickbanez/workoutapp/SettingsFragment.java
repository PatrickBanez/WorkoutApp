package com.patrickbanez.workoutapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    private View view;
    private Button profileButton;
    private ProfileFragment profileFragment;
    private SharedPreferences userPref;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        userPref = this.getActivity().getSharedPreferences(String.valueOf(R.string.user_sp), Context.MODE_PRIVATE);
        // Reading the saved user and creating a User object to pass to ProfileFragment
        Gson gson = new Gson();
        String json = userPref.getString(String.valueOf(R.string.user_data_key), "");
        User user = (User) gson.fromJson(json, User.class);

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_settings, container, false);
        profileButton = view.findViewById(R.id.profileButton);
        setButtonActions();
        profileFragment = new ProfileFragment(user);
        return view;
    }

    public void setButtonActions() {
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.activeView, profileFragment,null).commit();
            }
        });
    }
}