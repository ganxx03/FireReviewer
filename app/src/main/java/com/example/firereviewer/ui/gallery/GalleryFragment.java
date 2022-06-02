package com.example.firereviewer.ui.gallery;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.firereviewer.R;
import com.example.firereviewer.Reviewer;
import com.example.firereviewer.ui.about.AboutFragment;
import com.example.firereviewer.ui.home.HomeFragment;
import com.google.android.material.navigation.NavigationView;

public class GalleryFragment extends Fragment{


    //GALLERY IS REVIEWER
    //SLIDESHOW IS EXAM SIMULATOR
    private String selectedTopicName = "";
    Activity context;
    Dialog myDialog;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        myDialog = new Dialog(context);

        final LinearLayout ga = root.findViewById(R.id.gaLayout);
        final LinearLayout fs = root.findViewById(R.id.fsLayout);
        final LinearLayout fsp = root.findViewById(R.id.fspLayout);
        final LinearLayout fi = root.findViewById(R.id.fiLayout);
        final LinearLayout am = root.findViewById(R.id.amLayout);

        final Button btn = root.findViewById(R.id.button);



        ga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopicName = "General Ability";
                ga.setBackgroundResource(R.drawable.stroke10);

                fs.setBackgroundResource(R.drawable.white10);
                fsp.setBackgroundResource(R.drawable.white10);
                fi.setBackgroundResource(R.drawable.white10);
                am.setBackgroundResource(R.drawable.white10);
            }
        });
        fs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopicName = "Fire Suppression";
                fs.setBackgroundResource(R.drawable.stroke10);

                ga.setBackgroundResource(R.drawable.white10);
                fsp.setBackgroundResource(R.drawable.white10);
                fi.setBackgroundResource(R.drawable.white10);
                am.setBackgroundResource(R.drawable.white10);
            }
        });
        fsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopicName = "Fire Safety and Prevention";
                fsp.setBackgroundResource(R.drawable.stroke10);

                ga.setBackgroundResource(R.drawable.white10);
                fs.setBackgroundResource(R.drawable.white10);
                fi.setBackgroundResource(R.drawable.white10);
                am.setBackgroundResource(R.drawable.white10);
            }
        });
        fi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopicName = "Fire Investigation";
                fi.setBackgroundResource(R.drawable.stroke10);

                ga.setBackgroundResource(R.drawable.white10);
                fs.setBackgroundResource(R.drawable.white10);
                fsp.setBackgroundResource(R.drawable.white10);
                am.setBackgroundResource(R.drawable.white10);
            }
        });
        am.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopicName = "Administrative Matters";
                am.setBackgroundResource(R.drawable.stroke10);

                ga.setBackgroundResource(R.drawable.white10);
                fs.setBackgroundResource(R.drawable.white10);
                fsp.setBackgroundResource(R.drawable.white10);
                fi.setBackgroundResource(R.drawable.white10);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedTopicName.isEmpty()){
                    Toast.makeText(context, "Please select a topic!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(context, Reviewer.class);
                    intent.putExtra("selectedTopic", selectedTopicName);
                    startActivity(intent);
                }
            }
        });



        return root;
    }
    @Override
    public void onDetach() {
        super.onDetach();
        NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Home");
    }




}