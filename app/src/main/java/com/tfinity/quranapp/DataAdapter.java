package com.tfinity.quranapp;

import android.content.Context;
import android.content.SharedPreferences;
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
        super(context, R.layout.read_layout, ListViewArray);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DataModel m=getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.read_layout,parent,false);
        TextView surah=convertView.findViewById(R.id.Surah);
        TextView englishTranslation=convertView.findViewById(R.id.EnglishTranslation);
        TextView urduTranslation=convertView.findViewById(R.id.UrduTranslation);
        surah.setText(m.getArabic_Text());
        SharedPreferences sharedPreferences=context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        int urdu= sharedPreferences.getInt("Urdu",-1);
        int english=sharedPreferences.getInt("English",-1);
        if(urdu==1){
            urduTranslation.setText(m.getFateh_Muhammad_Jalandhri());
        }
        else if(urdu==2){
            urduTranslation.setText(m.getMehmood_ul_Hassan());
        }
        else{
            urduTranslation.setVisibility(View.GONE);
        }
        if(english==1){
            englishTranslation.setText(m.getDr_Mohsin_Khan());
        }
        else if(english==2){
            englishTranslation.setText(m.getMufti_Taqi_Usmani());
        }
        else{
            englishTranslation.setVisibility(View.GONE);
        }

        return convertView;
    }
}
