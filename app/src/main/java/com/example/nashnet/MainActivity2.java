package com.example.nashnet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import static com.example.nashnet.MainActivity.adress;
import static com.example.nashnet.MainActivity.date;
import static com.example.nashnet.MainActivity.mobphone;
import static com.example.nashnet.MainActivity.num;
import static com.example.nashnet.MainActivity.pib;
import static com.example.nashnet.MainActivity.taruf;


public class MainActivity2 extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView = findViewById(R.id.textView2);
        TextView textView2 = findViewById(R.id.textView3);
        TextView textView3 = findViewById(R.id.textView4);
        TextView textView4 = findViewById(R.id.textView5);
        TextView textView5 = findViewById(R.id.textView6);
        TextView textView6 = findViewById(R.id.textView8);

        textView.append(num.text());
        textView2.append(date.text());
        textView3.append(pib.text());
        textView4.append(adress.text());
        textView5.append(mobphone.text());
        textView6.setText(taruf);


    }
}