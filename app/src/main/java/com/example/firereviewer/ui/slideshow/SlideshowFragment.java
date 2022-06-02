package com.example.firereviewer.ui.slideshow;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.firereviewer.CheckProgress;
import com.example.firereviewer.ExamActivity;
import com.example.firereviewer.R;
import com.example.firereviewer.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {
    Activity context;
    Dialog myDialog;
    private int selectedNumberOfQuestions = 0;
    private int selectedTypeOfTimer = 0;

    //GALLERY IS REVIEWER
    //SLIDESHOW IS EXAM SIMULATOR
    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        myDialog = new Dialog(context);
        LinearLayout startLayout = root.findViewById(R.id.startLayout);
        LinearLayout progressLayout = root.findViewById(R.id.progressLayout);

        startLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowPopup();
            }
        });

        progressLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, CheckProgress.class));
            }
        });
        return root;
    }
    public void ShowPopup(){
        ImageView imgclose;
        Button btnStart;


        myDialog.setContentView(R.layout.custompopup);
        imgclose = myDialog.findViewById(R.id.gaClose);
        btnStart = myDialog.findViewById(R.id.cpbtnStart);
        LinearLayout forty = myDialog.findViewById(R.id.q40);
        LinearLayout sixty = myDialog.findViewById(R.id.q60);
        LinearLayout eighty = myDialog.findViewById(R.id.q80);
        LinearLayout hundred = myDialog.findViewById(R.id.q100);
        EditText minutesTimer = myDialog.findViewById(R.id.edtTimer);




        imgclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        forty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedNumberOfQuestions = 40;
                forty.setBackgroundResource(R.drawable.stroke10);
                sixty.setBackgroundResource(R.drawable.white10);
                eighty.setBackgroundResource(R.drawable.white10);
                hundred.setBackgroundResource(R.drawable.white10);
            }
        });
        sixty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedNumberOfQuestions = 60;
                sixty.setBackgroundResource(R.drawable.stroke10);

                forty.setBackgroundResource(R.drawable.white10);
                eighty.setBackgroundResource(R.drawable.white10);
                hundred.setBackgroundResource(R.drawable.white10);
            }
        });
        eighty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedNumberOfQuestions = 80;
                eighty.setBackgroundResource(R.drawable.stroke10);

                sixty.setBackgroundResource(R.drawable.white10);
                forty.setBackgroundResource(R.drawable.white10);
                hundred.setBackgroundResource(R.drawable.white10);
            }
        });
        hundred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedNumberOfQuestions = 100;
                hundred.setBackgroundResource(R.drawable.stroke10);

                sixty.setBackgroundResource(R.drawable.white10);
                eighty.setBackgroundResource(R.drawable.white10);
                forty.setBackgroundResource(R.drawable.white10);
            }
        });



        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedNumberOfQuestions<40) {
                    Toast.makeText(context, "Please select the number of questions!", Toast.LENGTH_SHORT).show();
                }

                else if(minutesTimer.length()==0){
                    minutesTimer.setError("Please enter a number");
                }


                else{
                    int timer = Integer.parseInt(minutesTimer.getText().toString());
                    if(timer>=61||timer<=2){
                        minutesTimer.setError("Minimum is 3 and Maximum is 60");
                    }
                    selectedTypeOfTimer = timer;
                    if(timer<=60&&timer>=3){
                        Intent intent = new Intent(context, ExamActivity.class);
                        intent.putExtra("selectedNumber", selectedNumberOfQuestions);
                        intent.putExtra("selectedTimer", selectedTypeOfTimer);
                        startActivity(intent);
                    }



                }
            }
        });
        myDialog.show();


    }

}