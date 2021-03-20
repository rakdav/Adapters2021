package com.example.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.listview);
        b1.setOnClickListener(this);
        b2=findViewById(R.id.spinner);
        b2.setOnClickListener(this);
        b3=findViewById(R.id.autoCompleteTextView);
        b3.setOnClickListener(this);
        b4=findViewById(R.id.Recycle);
        b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId())
        {
           case R.id.listview:
                intent=new Intent(MainActivity.this,ListViewActivity.class);
                break;
            case R.id.spinner:
                intent=new Intent(MainActivity.this,SpinnerActivity.class);
                break;
            case R.id.autoCompleteTextView:
                intent=new Intent(MainActivity.this,AutoCompliteActivity.class);
                break;
            case R.id.Recycle:
                intent=new Intent(MainActivity.this,RecycleActivity.class);
                break;
        }
        startActivity(intent);
    }
}