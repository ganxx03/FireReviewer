package com.example.firereviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CheckProgress extends AppCompatActivity {


    LineChart lineChart;
    DatabaseHandler dbh;
    SQLiteDatabase sdb;
    Button btnCPReset;

    LineDataSet lineDataSet = new LineDataSet(null, null);
    ArrayList<ILineDataSet> dataSets = new ArrayList<>();
    LineData lineData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_progress);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Progress");

        lineChart = findViewById(R.id.graph);
        btnCPReset = findViewById(R.id.btnCPReset);
        dbh = new DatabaseHandler(this);
        sdb = dbh.getWritableDatabase();


        getDataValues();
        grabData();

        XAxis xAxis = lineChart.getXAxis();
        YAxis yAxisL = lineChart.getAxisLeft();
        YAxis yAxisR = lineChart.getAxisRight();
        yAxisL.setGranularity(1f);
        yAxisR.setGranularity(1f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(1);
        xAxis.setGranularity(1f);
        lineChart.setPinchZoom(true);
        lineChart.setDragEnabled(true);
        lineChart.setDoubleTapToZoomEnabled(false);
        lineChart.setHorizontalScrollBarEnabled(true);

        btnCPReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(CheckProgress.this)
                        .setMessage("Are you sure you want to clear?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                lineChart.clear();
                                sdb.delete("ScoreTable",null, null);
                                Toast.makeText(CheckProgress.this, "Cleared progress!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();

            }
        });
    }


    //Line graph
    public void grabData() {
        lineDataSet.setValues(getDataValues());
        lineDataSet.setLabel("Score");
        lineDataSet.setColor(Color.parseColor("#FF1818"));
        lineDataSet.setValueTextSize(20);
        lineDataSet.setValueFormatter(new MyValueFormatter());
        dataSets.clear();
        dataSets.add(lineDataSet);
        lineData = new LineData(dataSets);
        lineChart.clear();
        lineChart.setData(lineData);
        lineChart.invalidate();
    }


    //Get data from the table
    private ArrayList<Entry> getDataValues() {
        ArrayList<Entry> dataVals = new ArrayList<>();
        String[] columns = {"xValue", "yValue"};
        Cursor cursor = sdb.query("ScoreTable", columns, null, null, null, null, null);

        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            dataVals.add(new Entry(cursor.getInt(0), cursor.getInt(1)));
        }

        return dataVals;
    }


    //Back button function in action bar
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }



    //Remove decimal point
    public class MyValueFormatter extends ValueFormatter {

        private DecimalFormat mFormat;

        public MyValueFormatter() {
            mFormat = new DecimalFormat("#");
        }

        @Override
        public String getFormattedValue(float value) {
            return mFormat.format(value);
        }
    }

}