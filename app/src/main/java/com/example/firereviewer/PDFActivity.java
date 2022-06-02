package com.example.firereviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFActivity extends AppCompatActivity {


    private int selectedPDF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfactivity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        PDFView pdfView = findViewById(R.id.pdfView);

        selectedPDF = getIntent().getIntExtra("selectedPDF", 0);
        if(selectedPDF==1){
            getSupportActionBar().setTitle("General Ability");
            pdfView.fromAsset("GenAbility.pdf").load();
        }
        else if(selectedPDF==2){
            getSupportActionBar().setTitle("Fire Suppression");
            pdfView.fromAsset("PFPT.pdf").load();
        }
        else if(selectedPDF==3){
            getSupportActionBar().setTitle("Fire Safety and Prevention");
            pdfView.fromAsset("FireSafety.pdf").load();
        }
        else if(selectedPDF==4){
            getSupportActionBar().setTitle("Fire Investigation");
            pdfView.fromAsset("fireinvestigation.pdf").load();
        }
        else if(selectedPDF==5){
            getSupportActionBar().setTitle("Administrative Matters");
            pdfView.fromAsset("administrative.pdf").load();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}