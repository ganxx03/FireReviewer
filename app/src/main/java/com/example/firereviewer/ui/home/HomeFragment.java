package com.example.firereviewer.ui.home;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.firereviewer.NavigationActivity;
import com.example.firereviewer.R;
import com.example.firereviewer.Reviewer;
import com.example.firereviewer.databinding.ActivityNavigationBinding;
import com.example.firereviewer.ui.about.AboutFragment;
import com.example.firereviewer.ui.dateofexam.DateFragment;
import com.example.firereviewer.ui.gallery.GalleryFragment;
import com.example.firereviewer.ui.pdfReviewer.pdfFragment;
import com.example.firereviewer.ui.slideshow.SlideshowFragment;
import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment {

    Activity context;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_home, container, false);
        LinearLayout reLayout = root.findViewById(R.id.reLayout);
        LinearLayout exLayout = root.findViewById(R.id.exLayout);
        LinearLayout pdfLayout = root.findViewById(R.id.pdfLayout);
        LinearLayout dateLayout = root.findViewById(R.id.dateLayout);
        LinearLayout abLayout = root.findViewById(R.id.abLayout);
        context = getActivity();



        reLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                navigationView.getMenu().getItem(1).setChecked(true);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_navigation, new GalleryFragment()).addToBackStack(null).commit();
                ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Reviewer");
            }
        });
        exLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                navigationView.getMenu().getItem(2).setChecked(true);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_navigation, new SlideshowFragment()).addToBackStack(null).commit();
                ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Exam Simulator");
            }
        });
        pdfLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                navigationView.getMenu().getItem(3).setChecked(true);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_navigation, new pdfFragment()).addToBackStack(null).commit();
                ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("PDF Reviewer");
            }
        });
        dateLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                navigationView.getMenu().getItem(4).setChecked(true);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_navigation, new DateFragment()).addToBackStack(null).commit();
                ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Date of Exam");
            }
        });
        abLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                navigationView.getMenu().getItem(5).setChecked(true);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_navigation, new AboutFragment()).addToBackStack(null).commit();
                ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("About");
            }
        });
        return root;
    }
}