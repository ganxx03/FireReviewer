package com.example.firereviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    Button btnContinue;
    SharedPreferences sp;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        edtName = findViewById(R.id.edtName);
        btnContinue = findViewById(R.id.btnContinue);
        sp = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sp.getString(KEY_NAME, null);

        if(name!=null){
            startActivity(new Intent(MainActivity.this,NavigationActivity.class));
            this.finish();
        }
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putString(KEY_NAME,edtName.getText().toString());
                editor.apply();
                startActivity(new Intent(MainActivity.this, NavigationActivity.class));
                finish();
            }
        });
    }
}