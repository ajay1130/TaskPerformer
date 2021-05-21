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
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class task2 extends AppCompatActivity {
    //  objects are created here for emailid,password & name
    //button object is created for login button
    TextInputLayout emailidlayout,passwordlayout,namelayout;
    Button loginbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        ActionBar actionBar = getSupportActionBar();

        // changing title of action bar
        actionBar.setTitle("Task2");

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        emailidlayout = findViewById(R.id.emailid);
        passwordlayout = findViewById(R.id.password);
        namelayout = findViewById(R.id.name);
        loginbutton = findViewById(R.id.loginbutton);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // we are getting emailid and password text
                String emailid = emailidlayout.getEditText().getText().toString();
                String password = passwordlayout.getEditText().getText().toString();
                String name = namelayout.getEditText().getText().toString();

                if (name.isEmpty() || emailid.isEmpty() || password.isEmpty() )
                {
                    Snackbar snackbar = Snackbar
                            .make(v, "Name,Email id & Password should not be null", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                //checks whether emailid is correct
                else if(!(isValidEmail(emailid)))
                {

                    Snackbar snackbar = Snackbar
                            .make(v, "Email id is not valid", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else{
                        emailidlayout.getEditText().setText("");
                        passwordlayout.getEditText().setText("");
                        namelayout.getEditText().setText("");


                        Intent nameemailintent = new Intent(getApplicationContext(),DisplayNameEmail.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("Name",name);
                        bundle.putString("Email",emailid);
                        nameemailintent.putExtras(bundle);
                        startActivity(nameemailintent);

                }

            }
        });


    }

    private boolean isValidEmail(String emailid){
        // we use patterns class to  match email id is valid or not
        return Patterns.EMAIL_ADDRESS.matcher(emailid).matches();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}