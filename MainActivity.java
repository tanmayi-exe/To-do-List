package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arr=new ArrayList<String>();
    EditText input;
    ListView listView;
    Button btn;
    ArrayAdapter<String> ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input= findViewById(R.id.EditText);
        listView=findViewById(R.id.lView);
        btn=findViewById(R.id.addBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ip=input.getText().toString().trim();
                if(ip.isEmpty())
                    Toast.makeText(MainActivity.this,"Input required",Toast.LENGTH_LONG).show();
                else
                    {
                    arr.add(ip);
                    ad = new ArrayAdapter<String>(getApplicationContext(), R.layout.list,R.id.TextView, arr);
                    listView.setAdapter(ad);
                    input.setText(" ");
                }

                }


            });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                arr.remove(i);
               //ArrayAdapter<String> ad = new ArrayAdapter<String>(getApplicationContext(), R.layout.list,R.id.TextView, arr);
                ad.notifyDataSetChanged();
                //listView.deferNotifyDataSetChanged();//what does this do??
                Toast.makeText(MainActivity.this,"Item deleted",Toast.LENGTH_LONG).show();
            }
        });
    }
}
