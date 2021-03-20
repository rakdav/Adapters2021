package com.example.adapters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.adapters.rec.Country;
import com.example.adapters.rec.CountryAdapter;

import java.util.ArrayList;

public class RecycleActivity extends AppCompatActivity {
    ArrayList<Country> countries;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        countries=new ArrayList<Country>();
        countries.add(new Country("Ирландия",R.drawable.irland,5000000));
        countries.add(new Country("Италия",R.drawable.italy,4500000));
        countries.add(new Country("Япония",R.drawable.japan,470000000));
        rv=findViewById(R.id.rv);

        CountryAdapter.OnCountryClickListener onCountryClickListener=new CountryAdapter.OnCountryClickListener() {
            @Override
            public void onCountryClick(Country country, int position) {
                Toast.makeText(RecycleActivity.this,country.getCountryName(),Toast.LENGTH_LONG).show();
            }
        };
        CountryAdapter countryAdapter=new CountryAdapter(countries,this,onCountryClickListener);
        rv.setAdapter(countryAdapter);
    }
}