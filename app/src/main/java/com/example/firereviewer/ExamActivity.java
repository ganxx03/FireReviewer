package com.example.firereviewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ExamActivity extends AppCompatActivity {

    private TextView question, questions, timerTV;
    private AppCompatButton option1, option2, option3, option4, nextBtn, Enextbtn, Epreviousbtn;
    Dialog myDialog;

    private List<QuestionsList> questionsLists;

    private int CurrentQuestionPosition = 0;
    private String selectedOptionByUser = "";
    private int getSelectedNumberOfQuestions = 0;
    private int getSelectedTypeOfTimer = 0;
    private Timer quizTimer;
    private int totalTimeInMins;
    private int seconds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Exam Simulator");

        myDialog = new Dialog(this);

        getSelectedNumberOfQuestions = getIntent().getIntExtra("selectedNumber",0);
        getSelectedTypeOfTimer = getIntent().getIntExtra("selectedTimer", 0);

        question = findViewById(R.id.Equestion);
        questions = findViewById(R.id.Equestions);
        timerTV = findViewById(R.id.Etimer);

        option1 = findViewById(R.id.Eoption1);
        option2 = findViewById(R.id.Eoption2);
        option3 = findViewById(R.id.Eoption3);
        option4 = findViewById(R.id.Eoption4);
        nextBtn = findViewById(R.id.EnextBtn);
        Enextbtn = findViewById(R.id.Enext);
        Epreviousbtn = findViewById(R.id.Eprevious);

        questionsLists = EQuestionsBank.getEQuestions(getSelectedNumberOfQuestions);
        questions.setText((CurrentQuestionPosition+1)+"/"+getSelectedNumberOfQuestions);
        question.setText(questionsLists.get(0).getQuestion());
        option1.setText(questionsLists.get(0).getOption1());
        option2.setText(questionsLists.get(0).getOption2());
        option3.setText(questionsLists.get(0).getOption3());
        option4.setText(questionsLists.get(0).getOption4());

        totalTimeInMins = getSelectedTypeOfTimer;

        startTimer(timerTV);


        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedOptionByUser = option1.getText().toString();
                option1.setBackgroundResource(R.drawable.blue10);
                option1.setTextColor(Color.WHITE);


                option2.setBackgroundResource(R.drawable.stroke2_10);
                option2.setTextColor(Color.parseColor("#000000"));

                option3.setBackgroundResource(R.drawable.stroke2_10);
                option3.setTextColor(Color.parseColor("#000000"));

                option4.setBackgroundResource(R.drawable.stroke2_10);
                option4.setTextColor(Color.parseColor("#000000"));


                questionsLists.get(CurrentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                /*if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.red10);
                    option1.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(CurrentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }*/
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedOptionByUser = option2.getText().toString();
                option2.setBackgroundResource(R.drawable.blue10);
                option2.setTextColor(Color.WHITE);

                option1.setBackgroundResource(R.drawable.stroke2_10);
                option1.setTextColor(Color.parseColor("#000000"));


                option3.setBackgroundResource(R.drawable.stroke2_10);
                option3.setTextColor(Color.parseColor("#000000"));

                option4.setBackgroundResource(R.drawable.stroke2_10);
                option4.setTextColor(Color.parseColor("#000000"));
                questionsLists.get(CurrentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                /*if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.red10);
                    option2.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(CurrentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }*/
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedOptionByUser = option3.getText().toString();
                option3.setBackgroundResource(R.drawable.blue10);
                option3.setTextColor(Color.WHITE);

                option1.setBackgroundResource(R.drawable.stroke2_10);
                option1.setTextColor(Color.parseColor("#000000"));

                option2.setBackgroundResource(R.drawable.stroke2_10);
                option2.setTextColor(Color.parseColor("#000000"));


                option4.setBackgroundResource(R.drawable.stroke2_10);
                option4.setTextColor(Color.parseColor("#000000"));
                questionsLists.get(CurrentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                /*if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.red10);
                    option3.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(CurrentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }*/
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedOptionByUser = option4.getText().toString();
                option4.setBackgroundResource(R.drawable.blue10);
                option4.setTextColor(Color.WHITE);

                option1.setBackgroundResource(R.drawable.stroke2_10);
                option1.setTextColor(Color.parseColor("#000000"));

                option2.setBackgroundResource(R.drawable.stroke2_10);
                option2.setTextColor(Color.parseColor("#000000"));

                option3.setBackgroundResource(R.drawable.stroke2_10);
                option3.setTextColor(Color.parseColor("#000000"));

                questionsLists.get(CurrentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                /*if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.red10);
                    option4.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(CurrentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }*/
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedOptionByUser.isEmpty()){
                    Toast.makeText(ExamActivity.this, "Please select an answer!", Toast.LENGTH_SHORT).show();
                }
                else{
                    changeNextQuestion();
                }
            }
        });

        Enextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CurrentQuestionPosition++;

                if((CurrentQuestionPosition+1)==getSelectedNumberOfQuestions){
                    Enextbtn.setVisibility(View.INVISIBLE);
                }
                else if((CurrentQuestionPosition+1)<getSelectedNumberOfQuestions){
                    Enextbtn.setVisibility(View.VISIBLE);
                    Epreviousbtn.setVisibility(View.VISIBLE);
                }
                selectedOptionByUser = "";

                option1.setBackgroundResource(R.drawable.stroke2_10);
                option1.setTextColor(Color.parseColor("#000000"));

                option2.setBackgroundResource(R.drawable.stroke2_10);
                option2.setTextColor(Color.parseColor("#000000"));

                option3.setBackgroundResource(R.drawable.stroke2_10);
                option3.setTextColor(Color.parseColor("#000000"));

                option4.setBackgroundResource(R.drawable.stroke2_10);
                option4.setTextColor(Color.parseColor("#000000"));

                questions.setText((CurrentQuestionPosition+1)+"/"+getSelectedNumberOfQuestions);
                question.setText(questionsLists.get(CurrentQuestionPosition).getQuestion());
                option1.setText(questionsLists.get(CurrentQuestionPosition).getOption1());
                option2.setText(questionsLists.get(CurrentQuestionPosition).getOption2());
                option3.setText(questionsLists.get(CurrentQuestionPosition).getOption3());
                option4.setText(questionsLists.get(CurrentQuestionPosition).getOption4());
            }
        });
        if((CurrentQuestionPosition+1)<2){
            Epreviousbtn.setVisibility(View.INVISIBLE);
            Enextbtn.setVisibility(View.VISIBLE);
        }


        Epreviousbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CurrentQuestionPosition--;

                if((CurrentQuestionPosition+1)>2){
                    Epreviousbtn.setVisibility(View.VISIBLE);
                    Enextbtn.setVisibility(View.VISIBLE);
                }

                else if((CurrentQuestionPosition+1)<2){
                    Epreviousbtn.setVisibility(View.INVISIBLE);
                    Enextbtn.setVisibility(View.VISIBLE);
                }
                selectedOptionByUser = "";

                option1.setBackgroundResource(R.drawable.stroke2_10);
                option1.setTextColor(Color.parseColor("#000000"));

                option2.setBackgroundResource(R.drawable.stroke2_10);
                option2.setTextColor(Color.parseColor("#000000"));

                option3.setBackgroundResource(R.drawable.stroke2_10);
                option3.setTextColor(Color.parseColor("#000000"));

                option4.setBackgroundResource(R.drawable.stroke2_10);
                option4.setTextColor(Color.parseColor("#000000"));

                questions.setText((CurrentQuestionPosition+1)+"/"+getSelectedNumberOfQuestions);
                question.setText(questionsLists.get(CurrentQuestionPosition).getQuestion());
                option1.setText(questionsLists.get(CurrentQuestionPosition).getOption1());
                option2.setText(questionsLists.get(CurrentQuestionPosition).getOption2());
                option3.setText(questionsLists.get(CurrentQuestionPosition).getOption3());
                option4.setText(questionsLists.get(CurrentQuestionPosition).getOption4());


            }
        });
    }


    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to go back?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        quizTimer.purge();
                        quizTimer.cancel();
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                new AlertDialog.Builder(this)
                        .setMessage("Are you sure you want to go back?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                quizTimer.purge();
                                quizTimer.cancel();
                                finish();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*private void revealAnswer(){
        final String getAnswer = questionsLists.get(CurrentQuestionPosition).getAnswer();

        if(option1.getText().toString().equals(getAnswer)){
            option1.setBackgroundResource(R.drawable.green10);
            option1.setTextColor(Color.WHITE);
        }
        else if(option2.getText().toString().equals(getAnswer)){
            option2.setBackgroundResource(R.drawable.green10);
            option2.setTextColor(Color.WHITE);
        }
        else if(option3.getText().toString().equals(getAnswer)){
            option3.setBackgroundResource(R.drawable.green10);
            option3.setTextColor(Color.WHITE);
        }
        else if(option4.getText().toString().equals(getAnswer)){
            option4.setBackgroundResource(R.drawable.green10);
            option4.setTextColor(Color.WHITE);
        }

    }*/

    private void changeNextQuestion(){
        CurrentQuestionPosition++;

        if((CurrentQuestionPosition+1)>1){
            Epreviousbtn.setVisibility(View.VISIBLE);
        }
        if((CurrentQuestionPosition+1)==getSelectedNumberOfQuestions){
            Enextbtn.setVisibility(View.INVISIBLE);
        }

        if(CurrentQuestionPosition<getSelectedNumberOfQuestions){
            selectedOptionByUser = "";

            option1.setBackgroundResource(R.drawable.stroke2_10);
            option1.setTextColor(Color.parseColor("#000000"));

            option2.setBackgroundResource(R.drawable.stroke2_10);
            option2.setTextColor(Color.parseColor("#000000"));

            option3.setBackgroundResource(R.drawable.stroke2_10);
            option3.setTextColor(Color.parseColor("#000000"));

            option4.setBackgroundResource(R.drawable.stroke2_10);
            option4.setTextColor(Color.parseColor("#000000"));

            questions.setText((CurrentQuestionPosition+1)+"/"+getSelectedNumberOfQuestions);
            question.setText(questionsLists.get(CurrentQuestionPosition).getQuestion());
            option1.setText(questionsLists.get(CurrentQuestionPosition).getOption1());
            option2.setText(questionsLists.get(CurrentQuestionPosition).getOption2());
            option3.setText(questionsLists.get(CurrentQuestionPosition).getOption3());
            option4.setText(questionsLists.get(CurrentQuestionPosition).getOption4());
        }
        else{
            showPopup();

        }
    }
    public void showPopup(){
        Button btnCancel, btnConfirm;

        myDialog.setContentView(R.layout.submitconfirm);
        btnCancel = myDialog.findViewById(R.id.btnCancel);
        btnConfirm = myDialog.findViewById(R.id.btnConfirm);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizTimer.purge();
                quizTimer.cancel();


                Intent intent = new Intent(ExamActivity.this, ExamResults.class);
                intent.putExtra("correct", getCorrectAnswers());
                intent.putExtra("incorrect", getIncorrectAnswers());
                startActivity(intent);

                finish();
            }
        });
        myDialog.show();
    }

    private void startTimer(TextView timerTextView){

        quizTimer = new Timer();

        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(seconds==0 && totalTimeInMins==0){
                    quizTimer.purge();
                    quizTimer.cancel();


                    Intent intent = new Intent(ExamActivity.this, ExamResults.class);
                    intent.putExtra("correct", getCorrectAnswers());
                    intent.putExtra("incorrect", getIncorrectAnswers());
                    startActivity(intent);

                    finish();
                }
                else if(seconds==0){
                    totalTimeInMins--;
                    seconds=59;
                }

                else{
                    seconds--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String finalMinutes = String.valueOf(totalTimeInMins);
                        String finalSeconds = String.valueOf(seconds);

                        if(finalMinutes.length() == 1){
                            finalMinutes = "0"+finalMinutes;
                        }
                        if(finalSeconds.length() == 1){
                            finalSeconds = "0"+finalSeconds;
                        }
                        timerTextView.setText(finalMinutes+":"+finalSeconds);
                    }
                });
            }
        },1000, 1000);
    }

    private int getCorrectAnswers(){

        int correctAnswers = 0;

        for(int i=0;i<getSelectedNumberOfQuestions;i++){
            final String getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if(getUserSelectedAnswer.equals(getAnswer)){
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    private int getIncorrectAnswers(){

        int IncorrectAnswers = 0;

        for(int i=0;i<getSelectedNumberOfQuestions;i++){
            final String getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if(!getUserSelectedAnswer.equals(getAnswer)){
                IncorrectAnswers++;
            }
        }
        return IncorrectAnswers;
    }
}