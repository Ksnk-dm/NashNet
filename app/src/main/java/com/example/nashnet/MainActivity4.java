package com.example.nashnet;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import static com.example.nashnet.MainActivity.trafdate;
import static com.example.nashnet.MainActivity.trafdown;
import static com.example.nashnet.MainActivity.trafsumm;
import static com.example.nashnet.MainActivity.trafupl;

public class MainActivity4 extends AppCompatActivity {

    public ListView list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        MyAdapterTraff adapter = new MyAdapterTraff(this, trafdate, trafdown, trafupl, trafsumm);
        Log.d("111", trafdate.toString() + trafdown.toString() + trafupl + trafsumm);
        list2 = (ListView) findViewById(R.id.list2);
        list2.setAdapter(adapter);

    }
}