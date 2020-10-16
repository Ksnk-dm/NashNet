package com.example.nashnet;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class MyAdapterhistory extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> date;


    public MyAdapterhistory(Activity context, ArrayList date) {
        super(context, R.layout.history, date);
        this.context = context;
        this.date = date;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.history, null, true);

        TextView dat = (TextView) rowView.findViewById(R.id.textViewdate);
        dat.setText(date.get(position));
        if (date.get(position).equalsIgnoreCase("")) {
            dat.setText("------------------------------------------------------------------------------------------");
        }
        if (date.get(position).equalsIgnoreCase("Дата  Сума Опис")) {
            dat.setText("Статистика оплат та списань за весь період:");
        }


        return rowView;
    }
}
