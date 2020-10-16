package com.example.nashnet;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapterTraff extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> date;
    private final ArrayList<String> traff1;
    private final ArrayList<String> traff2;
    private final ArrayList<String> trafall;


    public MyAdapterTraff(Activity context, ArrayList date, ArrayList traff1, ArrayList traff2, ArrayList trafall) {
        super(context, R.layout.traff, date);
        this.context = context;
        this.date = date;
        this.traff1 = traff1;
        this.traff2 = traff2;
        this.trafall = trafall;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.traff, null, true);

        TextView dat = (TextView) rowView.findViewById(R.id.textViewdate);
        TextView traftext = (TextView) rowView.findViewById(R.id.textViewtraf);
        TextView trafup = (TextView) rowView.findViewById(R.id.textViewtraup);
        TextView trafsumm = (TextView) rowView.findViewById(R.id.textViewtrafal);
        dat.setText(date.get(position));

            traftext.setText(traff1.get(position));
            trafup.setText(traff2.get(position));
            trafsumm.setText(trafall.get(position));
            

        return rowView;
    }
}
