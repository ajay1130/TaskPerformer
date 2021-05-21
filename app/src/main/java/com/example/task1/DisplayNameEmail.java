package com.example.task1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DisplayNameEmail extends AppCompatActivity {
    ListView name_email_listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_name_email);
        ActionBar actionBar = getSupportActionBar();

        // changing title of action bar
        actionBar.setTitle("Display List of Name & Email");

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("Name");
        String email = bundle.getString("Email");
//        Toast.makeText(getApplicationContext(),name+email,Toast.LENGTH_LONG).show();

        List<NameEmail> nameEmailList = new ArrayList<>();
        NameEmail nameEmail = new NameEmail(name,email);
        nameEmailList.add(nameEmail);

        SharedPrefrencesConfig.saveData(getApplicationContext(),nameEmailList);

        nameEmailList=  SharedPrefrencesConfig.readData(getApplicationContext());

//
//        for(int i=0; i<nameEmailList.size();i++)
//        {
//            Log.d("testdata",nameEmailList.get(i).getEmail()+"\t"+nameEmailList.get(i).getName());
//        }



        name_email_listview = findViewById(R.id.name_email_listview);
        Collections.reverse(nameEmailList);
        NameEmailAdpater nameEmailAdpater = new NameEmailAdpater(getApplicationContext(),R.layout.items2, (ArrayList<NameEmail>) nameEmailList);
        name_email_listview.setAdapter(nameEmailAdpater);



    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

}