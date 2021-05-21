package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void performTask1(View view) {
        //here we are directly calling intent because no data to send and it will call task1
        startActivity(new Intent(getApplicationContext(),task1.class));
    }

    public void performTask2(View view) {
        //here we are directly calling intent because no data to send and it will call task2
        startActivity(new Intent(getApplicationContext(),task2.class));
    }
}