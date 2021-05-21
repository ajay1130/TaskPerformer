package com.example.task1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DisplayImageName extends AppCompatActivity {
    RecyclerView imagenamerecyclerview;
    LinearLayout coordinate;
    List<JsonData> jsonDataList;
    private String DisplayImageNameTAG="Displayimagename";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image_name);
        ActionBar actionBar = getSupportActionBar();

        // changing title of action bar
        actionBar.setTitle("Display Images & Name");

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        coordinate = findViewById(R.id.displayimagenamelayout);

        imagenamerecyclerview = findViewById(R.id.imagenamerecyclerview);
        imagenamerecyclerview.setHasFixedSize(true);
        imagenamerecyclerview.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        jsonDataList = new ArrayList<>();
        imagenamerecyclerview.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        fetchData();


    }

    private void fetchData() {

        String url = "https://jsonplaceholder.typicode.com/photos";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i=0; i<response.length(); i++)
                {

                    try
                    {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String title = jsonObject.getString("title");
                        String pictureurl = jsonObject.getString("url");
                        String thumbnailurl = jsonObject.getString("thumbnailUrl");
                        JsonData jsonData = new JsonData(title,pictureurl,thumbnailurl);
                        jsonDataList.add(jsonData);
                        Log.d(DisplayImageNameTAG, jsonData.getPictureurl());
                    }
                    catch (JSONException e)
                    {
                        e.printStackTrace();
                    }

                }

                JsonDataAdpater adpater = new JsonDataAdpater(DisplayImageName.this,jsonDataList);

                imagenamerecyclerview.setAdapter(adpater);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Snackbar snackbar = Snackbar
                        .make(coordinate, error.getMessage(), Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);

    }
}