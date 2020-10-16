package com.example.nashnet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;



import static com.example.nashnet.MainActivity.info;
import static com.example.nashnet.MainActivity.pib;


public class MainActivity3  extends Activity {


    public static ArrayList<String> sum = new ArrayList<String>();
    public ArrayList<String> detaile = new ArrayList<String>();
    public    ListView list;
    public static Elements bb1;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        MyAdapterhistory adapter=new MyAdapterhistory(this, info);
     info.remove(0);
        info.remove(1);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        Log.d("mes!!2", info.toString());







    }
}