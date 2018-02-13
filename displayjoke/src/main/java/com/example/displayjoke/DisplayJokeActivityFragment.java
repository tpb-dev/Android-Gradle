package com.example.displayjoke;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

/**
 * A placeholder fragment containing a simple view.
 */
public class DisplayJokeActivityFragment extends Fragment {

    Gson gson = new Gson();
    String joke = "";

    public DisplayJokeActivityFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null) {
            joke = getArguments().getString("joke");
            //Toast.makeText(getContext(), joke, Toast.LENGTH_LONG).show();;
        }
/*
        if(savedInstanceState == null){
            // Get back arguments

        } else {
            joke = savedInstanceState.getString("joke");
        }
        */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_display_joke, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        if(joke != null && !joke.equalsIgnoreCase("")) {
            Toast.makeText(getContext(), joke, Toast.LENGTH_LONG).show();;
        }
    }


}
