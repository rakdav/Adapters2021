package com.example.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    private String[] countriesArray={"Russia","USA","Chaina","France"};
   // private String[] countries;
    private ArrayList<String> countries;
    private GridView countryList;
    private TextView tv;
    private EditText text;
    private Button add,sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        countryList=findViewById(R.id.countryList);
        tv=findViewById(R.id.text);
        //countries=getResources().getStringArray(R.array.countries);
        countries=new ArrayList<String>();
        countries.add("Russia");
        countries.add("Germany");
        text=findViewById(R.id.newcountry);
        add=findViewById(R.id.add);
        sub=findViewById(R.id.sub);
        //ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,countries);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice,countries);
        countryList.setAdapter(adapter);
        countryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String selexted=countries[position];
               // Toast.makeText(ListViewActivity.this,selexted,Toast.LENGTH_LONG).show();
                SparseBooleanArray selexted=countryList.getCheckedItemPositions();
                String selected="";
                for(int i=0;i<countries.size();i++){
                    if(selexted.get(i)) selected+=countries.get(i)+",";
                }
                tv.setText(selected);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String country=text.getText().toString();
                if(!country.isEmpty())
                {
                    adapter.add(country);
                    text.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
    }
}