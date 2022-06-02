package com.example.firereviewer.ui.pdfReviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.firereviewer.PDFActivity;
import com.example.firereviewer.R;

public class pdfFragment extends Fragment {

    Activity context;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.pdf_fragment, container, false);
        context = getActivity();

        Button btnPDFGeneral = root.findViewById(R.id.btnPDFGeneral);
        Button btnPDFFireInvestigation = root.findViewById(R.id.btnPDFFireInvestigation);
        Button btnPDFAdministrative = root.findViewById(R.id.btnPDFAdministrative);
        Button btnPDFFireSuppression = root.findViewById(R.id.btnPDFFireSuppression);
        Button btnPDFFireSafety = root.findViewById(R.id.btnPDFFireSafety);

        btnPDFGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PDFActivity.class);
                intent.putExtra("selectedPDF", 1);
                startActivity(intent);
            }
        });

        btnPDFFireSuppression.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PDFActivity.class);
                intent.putExtra("selectedPDF", 2);
                startActivity(intent);
            }
        });

        btnPDFFireSafety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PDFActivity.class);
                intent.putExtra("selectedPDF", 3);
                startActivity(intent);
            }
        });


        btnPDFFireInvestigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PDFActivity.class);
                intent.putExtra("selectedPDF", 4);
                startActivity(intent);
            }
        });

        btnPDFAdministrative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PDFActivity.class);
                intent.putExtra("selectedPDF", 5);
                startActivity(intent);
            }
        });



        return root;
    }

}