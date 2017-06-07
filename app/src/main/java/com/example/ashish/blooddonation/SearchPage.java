package com.example.ashish.blooddonation;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchPage extends AppCompatActivity {
    AppDataBase database;
    ArrayList list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);
        database=new AppDataBase(this);
    }
    public void showdata(View v) {
        EditText ed = (EditText) findViewById(R.id.bgroup);
        EditText ed1 = (EditText) findViewById(R.id.city);
        String bgroup = ed.getText().toString();
        try {
            ArrayList<Person> list = new ArrayList<Person>();
            Cursor cr = database.getData(bgroup);
            while (cr.moveToNext()) {
                Person p = new Person();
                String s1 = cr.getString(0);
                String s2 = cr.getString(1);
                String s3 = cr.getString(2);
                String s4 = cr.getString(3);
                String s5 = cr.getString(4);
                String s6 = cr.getString(5);
                p.setName(s1);
                p.setAge(s2);
                p.setBgroup(s3);
                p.setGender(s4);
                p.setMobiNo(s5);
                p.setAddress(s6);
                list.add(p);
                Log.v("Data Name", p.getName());
            }
            Intent intent = new Intent(SearchPage.this, ShowData.class);
            Log.v("DataInLIST", list.get(0).getName());
            intent.putExtra("FILES_TO_SEND", list);
            startActivity(intent);
            Log.v("hello 1", bgroup);
            ed.setText("");
            ed1.setText("");
        }
        catch (Exception e){
            Toast.makeText(this, "Blood group doest not exist in record", Toast.LENGTH_SHORT).show();
        }
    }
    public void showdata1(View v) {
        EditText ed = (EditText) findViewById(R.id.bgroup);
        EditText ed1 = (EditText) findViewById(R.id.city);
        String city = ed1.getText().toString();
        try {
            ArrayList<Person> list = new ArrayList<Person>();
            Cursor cr = database.getData1(city);
            while (cr.moveToNext()) {
                Person p = new Person();
                String s1 = cr.getString(0);
                String s2 = cr.getString(1);
                String s3 = cr.getString(2);
                String s4 = cr.getString(3);
                String s5 = cr.getString(4);
                String s6 = cr.getString(5);
                p.setName(s1);
                p.setAge(s2);
                p.setBgroup(s3);
                p.setGender(s4);
                p.setMobiNo(s5);
                p.setAddress(s6);
                list.add(p);
                Log.v("location", p.getAddress());
            }
            Intent intent = new Intent(SearchPage.this, ShowData.class);
            Log.v("DataInLIST", list.get(5).getAddress());
            intent.putExtra("FILES_TO_SEND", list);
            startActivity(intent);
            Log.v("hello 2", city);
            ed.setText("");
            ed1.setText("");
        }
        catch (Exception e){
            Toast.makeText(this, "city doest not exist in record", Toast.LENGTH_SHORT).show();
        }
    }
}
