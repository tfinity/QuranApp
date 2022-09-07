package com.tfinity.quranapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataAdapter extends ArrayAdapter<DataModel> {
    Context context;
    public DataAdapter(@NonNull Context context, ArrayList<DataModel> ListViewArray) {
        super(context, R.layout.paralistview, ListViewArray);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DataModel m=getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.paralistview,parent,false);
        TextView name=convertView.findViewById(R.id.ParaName);
        name.setText(m.getName());
        return convertView;
    }
}
