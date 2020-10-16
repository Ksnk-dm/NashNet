package com.example.nashnet;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;



public class MainActivity extends Activity {
    public static Element num;
    public static Element date;
    public static Element pib;
    public static Element adress;
    public static Element mobphone;
    public static String taruf;
    public static String log;
    public static String pas;
    public static Element number;
    public static Element errormes;
    public static String status;


    public static ArrayList<String> info = new ArrayList<String>();
    public static ArrayList<String> trafdate = new ArrayList<String>();
    public static ArrayList<String> trafdown = new ArrayList<String>();
    public static ArrayList<String> trafupl = new ArrayList<String>();
    public static ArrayList<String> trafsumm = new ArrayList<String>();
    public TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new NewThread().execute();
        textView = findViewById(R.id.textView9);


    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }


    public void Pay(View view) {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);


    }

    public void Onclicktraf(View view) {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);


    }

    public class NewThread extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... arg) {

            try {

                Connection.Response loginForm = Jsoup
                        .connect("https://my.nashnet.ua/index.php")
                        .method(Connection.Method.GET)
                        .execute();

                Connection.Response response = Jsoup.connect("https://my.nashnet.ua/index.php")
                        .data("login", log)
                        .data("password", pas)
                        .cookies(loginForm.cookies())
                        .method(Connection.Method.POST)
                        .execute();
                Document doc2 = Jsoup
                        .connect("https://my.nashnet.ua/index.php?mod=profile")
                        .cookies(response.cookies())
                        .get();
                Document doc = Jsoup
                        .connect("https://my.nashnet.ua/index.php")
                        .cookies(response.cookies())
                        .get();
                Document doc3 = Jsoup
                        .connect("https://my.nashnet.ua/index.php?mod=payments")
                        .cookies(response.cookies())
                        .get();
                Document doc4 = Jsoup
                        .connect("https://my.nashnet.ua/index.php?mod=traffic")
                        .cookies(response.cookies())
                        .get();
                Elements a = doc2.getElementsByTag("tbody");
                Elements b = doc.getElementsByTag("tbody");
                Element c = doc3.select("table").get(1);
                Elements td = c.select("tr");


                Elements table = doc4.getElementsByTag("tbody");

                Element rows = table.get(1);
                Elements elements_rows = rows.children();
                trafdate.clear();
                trafupl.clear();
                trafdown.clear();
                trafsumm.clear();

                for (int i = 5; i < elements_rows.size() - 5; i++) {
                    if (i % 2 == 0) {
                        elements_rows.append("+");
                    } else {
                        Element element = elements_rows.get(i);
                        Elements elements = element.children();
                        Element date = elements.get(0);
                        Element traf1 = elements.get(1);
                        Element traf2 = elements.get(2);
                        Element trafsum = elements.get(3);
                        trafdate.add(date.text());
                        trafdown.add(traf1.text());
                        trafupl.add(traf2.text());
                        trafsumm.add(trafsum.text());
                        Log.d("!!!", date.text() + " " + String.format("%1.2s", traf1.text()) + "гб" + " " + String.format("%5.1s", traf2.text()) + "гб" + " " + String.format("%1.2s", trafsum.text()) + "гб");
                    }
                }

                errormes = response.parse().getElementById("error_text");


                if (errormes == null) {

                    TextView rah = findViewById(R.id.textView10);
                    TextView bal = findViewById(R.id.textView11);
                    bal.append(b.get(1).select("tr").get(1).select("td").text());
                    number = a.get(2).select("tr").get(1).select("tr").get(0).select("tr").get(1);
                    num = number;
                    rah.append(num.text());
                    Element datedoc = a.get(2).select("tr").get(1).select("tr").get(0).select("tr").get(2);
                    date = datedoc;
                    Element lastname = a.get(2).select("tr").get(1).select("tr").get(0).select("tr").get(3);
                    pib = lastname;
                    Element allname = a.get(2).select("tr").get(1).select("tr").get(0).select("tr").get(3).select("td").get(1);
                    Element adres = a.get(2).select("tr").get(1).select("tr").get(0).select("tr").get(4);
                    adress = adres;
                    Element mobile = a.get(2).select("tr").get(1).select("tr").get(0).select("tr").get(6).children().get(1);
                    mobphone = mobile;
                    info.clear();


                    for (int i = 0; i < td.size(); i++) {
                        Element row = td.get(i);
                        Elements row2 = row.select("td");
                        info.add(row2.text());
                    }


                    taruf = "";
                    for (int i = 1; i < 10; i++) {
                        Element ball = a.get(4).select("td").get(1).select("tr").get(i);
                        taruf += "\n " + ball.text();
                    }
                    errormes = null;
                } else {
                    Intent intents = new Intent(MainActivity.this, Login.class);
                    startActivity(intents);
                    errormes.text();
                    finish();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            textView.append(pib.text());

        }
    }

}