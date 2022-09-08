package com.tfinity.quranapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyVH>{
    ArrayList<DataModel> data;
    String name;

    public RecyclerViewAdapter(ArrayList<DataModel> data,String name) {
        this.data = data;
        this.name=name;
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_layout,parent,false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
        holder.modelData= data.get(position);
        Log.d("testing name", "onBindViewHolder: "+name);
        if(name.equals("fatehMuhammad")){
            Log.d("testing", "onBindViewHolder: fatehmehmood");
            holder.text.setText(holder.modelData.getFateh_Muhammad_Jalandhri());
        }
        else if(name.equals("mehmoodUlHassan")){
            holder.text.setText(holder.modelData.getMehmood_ul_Hassan());
        }
        else if(name.equals("drMohsin")){
            holder.text.setText(holder.modelData.getDr_Mohsin_Khan());
        }
        else if( name.equals("muftiTaqi")){
            holder.text.setText(holder.modelData.getMufti_Taqi_Usmani());
        }

    }

    public class MyVH extends RecyclerView.ViewHolder {
        TextView text;
        DataModel modelData;
        public MyVH(@NonNull View itemView){
            super(itemView);
            text=itemView.findViewById(R.id.TranslationsText);
        }
    }
}
