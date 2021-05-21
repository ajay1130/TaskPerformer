package com.example.task1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class JsonDataAdpater extends RecyclerView.Adapter<JsonDataAdpater.JsonDataHolder> {

    Context context;
    List<JsonData> jsonDataList;

    public JsonDataAdpater(Context context, List<JsonData> jsonDataList) {
        this.context = context;
        this.jsonDataList = jsonDataList;
    }

    @NonNull
    @Override
    public JsonDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items,parent,false);
        return new JsonDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JsonDataHolder holder, int position) {
        JsonData currentdata = jsonDataList.get(position);
        holder.Title.setText(currentdata.getTitle());
        Log.d("jsondataadpater",currentdata.getThumbnailurl());

            Glide.with(context).
                    load(currentdata.getThumbnailurl()+".jpg")
                    .centerCrop()
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.Thumbnail);

    }

    @Override
    public int getItemCount() {
        return jsonDataList.size();
    }

    public class JsonDataHolder extends RecyclerView.ViewHolder {
        TextView Title;
        ImageView Thumbnail;
        public JsonDataHolder(@NonNull View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.title);
            Thumbnail = itemView.findViewById(R.id.imageholder);
        }
    }
}
