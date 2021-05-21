package com.example.task1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class task1 extends AppCompatActivity {
    // two objects are created here for emailid and password
    //button object is created for login button
    TextInputLayout emailidlayout,passwordlayout;
    Button loginbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);
        ActionBar actionBar = getSupportActionBar();

        // changing title of action bar
        actionBar.setTitle("Task1");

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        //it initialize that objects to emaiid,password & login button

        emailidlayout = findViewById(R.id.emailid);
        passwordlayout = findViewById(R.id.password);
        loginbutton = findViewById(R.id.loginbutton);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // we are getting emailid and password text
                String emailid = emailidlayout.getEditText().getText().toString();
                String password = passwordlayout.getEditText().getText().toString();

                //checks whether emailid is empty
                if(emailid.isEmpty()) {
                    Snackbar snackbar = Snackbar
                            .make(v, "Email id should not be null", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }

                //checks whether emailid is correct
                else if(!(isValidEmail(emailid)))
                {

                    Snackbar snackbar = Snackbar
                            .make(v, "Email id is not valid", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }

                //checks whether emailid & password are correct
                else if(!(isAuthenticated(emailid,password)))
                {
                    Snackbar snackbar = Snackbar
                            .make(v, "Email id or Password are incorrect", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }

                //if emailid and password are correct we will switch to other activity
                else{
                    emailidlayout.getEditText().setText("");
                    passwordlayout.getEditText().setText("");
                    startActivity(new Intent(getApplicationContext(),DisplayImageName.class));
                }

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    private boolean isValidEmail(String emailid){
        // we use patterns class to  match email id is valid or not
        return Patterns.EMAIL_ADDRESS.matcher(emailid).matches();

    }

    private boolean isAuthenticated(String emailid,String password){

        return emailid.equals(getString(R.string.emailid)) && password.equals(getString(R.string.password));

    }
}
