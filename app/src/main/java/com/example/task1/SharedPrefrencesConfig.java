package com.example.task1;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SharedPrefrencesConfig {
    private static  final String LIST_KEY = "nameemaillist";
    public static void saveData(Context context, List<NameEmail> nameEmailList)
    {

            List<NameEmail> previousdata;
            previousdata = SharedPrefrencesConfig.readData(context);
            if(previousdata==null)
            {
                previousdata = new ArrayList<>();
            }
            NameEmail nameEmail = new NameEmail(nameEmailList.get(0).getName(),nameEmailList.get(0).getEmail());
            previousdata.add(nameEmail);
            Gson gson = new Gson();
            String jsonString = gson.toJson(previousdata);

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(LIST_KEY,jsonString);
            editor.apply();

    }

    public static List<NameEmail> readData(Context context)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = preferences.getString(LIST_KEY,"");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<NameEmail>>(){}.getType();
        List<NameEmail> nameEmailList = gson.fromJson(jsonString,type);
        return nameEmailList;
    }

}
