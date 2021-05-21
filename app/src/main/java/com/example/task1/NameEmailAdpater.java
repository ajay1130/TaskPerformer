package com.example.task1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NameEmailAdpater extends ArrayAdapter<NameEmail> {
    private  Context context;
    int mResource;

    public NameEmailAdpater(Context context, int resource, ArrayList<NameEmail> nameEmaillist) {
        super(context, resource, nameEmaillist);
        this.context=context;
        mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        String email = getItem(position).getEmail();

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(mResource,parent,false);

        TextView namedisplaytext,emaildisplaytext;
        namedisplaytext = convertView.findViewById(R.id.displayname);
        emaildisplaytext = convertView.findViewById(R.id.displayemail);

        namedisplaytext.setText("Name: "+name);
        emaildisplaytext.setText("Email: "+email);


        return convertView;
    }
}
