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

public class ParaListAdapter extends ArrayAdapter<ParaModel> {
    Context context;
    public ParaListAdapter(@NonNull Context context, ArrayList<ParaModel> ListViewArray) {
        super(context, R.layout.paralistview, ListViewArray);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ParaModel m=getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.paralistview,parent,false);
        TextView name=convertView.findViewById(R.id.ParaName);
        name.setText(m.getName());
        return convertView;
    }
}
