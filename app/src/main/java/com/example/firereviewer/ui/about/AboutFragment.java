package com.example.firereviewer.ui.about;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.firereviewer.R;

public class AboutFragment extends Fragment {

    //GALLERY IS REVIEWER
    //SLIDESHOW IS EXAM SIMULATOR
    Activity context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.about_fragment, container, false);
        context = getActivity();
        return root;
    }

}