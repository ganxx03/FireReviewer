package com.example.firereviewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Reviewer extends AppCompatActivity {

    private TextView question, questions;
    private AppCompatButton option1, option2, option3, option4, nextBtn;

    private List<QuestionsList> questionsLists;

    private int CurrentQuestionPosition = 0;

    private String selectedOptionByUser = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviewer);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setTitle("Reviewer");

        final String getSelectedTopicName = getIntent().getStringExtra("selectedTopic");
        final TextView selectedTopicName = findViewById(R.id.topicName);

        question = findViewById(R.id.question);
        questions = findViewById(R.id.questions);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextBtn = findViewById(R.id.nextBtn);

        selectedTopicName.setText(getSelectedTopicName);

        questionsLists = QuestionsBank.getQuestions(getSelectedTopicName);
        questions.setText((CurrentQuestionPosition+1)+"/"+questionsLists.size());
        question.setText(questionsLists.get(0).getQuestion());
        option1.setText(questionsLists.get(0).getOption1());
        option2.setText(questionsLists.get(0).getOption2());
        option3.setText(questionsLists.get(0).getOption3());
        option4.setText(questionsLists.get(0).getOption4());

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.red10);
                    option1.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(CurrentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.red10);
                    option2.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(CurrentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.red10);
                    option3.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(CurrentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.red10);
                    option4.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(CurrentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedOptionByUser.isEmpty()){
                    Toast.makeText(Reviewer.this, "Please select an answer!", Toast.LENGTH_SHORT).show();
                }
                else{
                    changeNextQuestion();
                }
            }
        });
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to go back?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
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
                                finish();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void revealAnswer(){
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

    }

    private void changeNextQuestion(){
        CurrentQuestionPosition++;
        if((CurrentQuestionPosition+1)==questionsLists.size()){
            nextBtn.setText("Submit Quiz");
        }
        if(CurrentQuestionPosition < questionsLists.size()){
            selectedOptionByUser = "";

            option1.setBackgroundResource(R.drawable.stroke2_10);
            option1.setTextColor(Color.parseColor("#000000"));

            option2.setBackgroundResource(R.drawable.stroke2_10);
            option2.setTextColor(Color.parseColor("#000000"));

            option3.setBackgroundResource(R.drawable.stroke2_10);
            option3.setTextColor(Color.parseColor("#000000"));

            option4.setBackgroundResource(R.drawable.stroke2_10);
            option4.setTextColor(Color.parseColor("#000000"));

            questions.setText((CurrentQuestionPosition+1)+"/"+questionsLists.size());
            question.setText(questionsLists.get(CurrentQuestionPosition).getQuestion());
            option1.setText(questionsLists.get(CurrentQuestionPosition).getOption1());
            option2.setText(questionsLists.get(CurrentQuestionPosition).getOption2());
            option3.setText(questionsLists.get(CurrentQuestionPosition).getOption3());
            option4.setText(questionsLists.get(CurrentQuestionPosition).getOption4());
        }
        else{
            Toast.makeText(Reviewer.this, "Done!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}