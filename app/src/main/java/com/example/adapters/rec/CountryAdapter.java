package com.example.adapters.rec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapters.R;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder>
{
    public interface  OnCountryClickListener{
        void onCountryClick(Country country,int position);
    }
    private OnCountryClickListener onCountryClickListener;
    private List<Country> countries;
    private Context context;
    private LayoutInflater layoutInflater;

    public CountryAdapter(List<Country> countries, Context context,OnCountryClickListener onCountryClickListener) {
        this.countries = countries;
        this.context = context;
        layoutInflater=LayoutInflater.from(context);
        this.onCountryClickListener=onCountryClickListener;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.recycleview_item_layout,parent,false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country=countries.get(position);
        holder.flagImage.setImageResource(country.getFlagName());
        holder.countryTV.setText(country.getCountryName());
        holder.populationTV.setText(Integer.toString(country.getPopulation()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCountryClickListener.onCountryClick(country,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder
    {
        ImageView flagImage;
        TextView countryTV;
        TextView populationTV;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            flagImage=itemView.findViewById(R.id.flag);
            countryTV=itemView.findViewById(R.id.country);
            populationTV=itemView.findViewById(R.id.population);
        }
    }
}
