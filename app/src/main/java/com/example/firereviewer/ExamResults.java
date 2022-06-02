package com.example.firereviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firereviewer.ui.home.HomeFragment;
import com.github.mikephil.charting.charts.LineChart;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExamResults extends AppCompatActivity {

    private TextView scoreResult, scoreResult2;
    private Button btnRHome;

    DatabaseHandler dbh;
    SQLiteDatabase sdb;

    int getCorrectAnswers, getIncorrectAnswers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_results);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setTitle("Exam Simulator");

        scoreResult = findViewById(R.id.scoreResult);
        scoreResult2 = findViewById(R.id.scoreResult2);
        btnRHome = findViewById(R.id.btnRHome);
        dbh = new DatabaseHandler(this);
        sdb = dbh.getWritableDatabase();


        getCorrectAnswers = getIntent().getIntExtra("correct", 0);
        getIncorrectAnswers = getIntent().getIntExtra("incorrect", 0);

        scoreResult.setText("Correct: "+String.valueOf(getCorrectAnswers));
        scoreResult2.setText("Incorrect: "+String.valueOf(getIncorrectAnswers));
        Toast.makeText(this, "Score has been saved!", Toast.LENGTH_SHORT).show();
        insertDatabase();



        btnRHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExamResults.this, NavigationActivity.class));
                finish();
            }
        });
    }

    public void insertDatabase(){
        int yVal = getCorrectAnswers;

        dbh.insertdata(yVal);
    }




}