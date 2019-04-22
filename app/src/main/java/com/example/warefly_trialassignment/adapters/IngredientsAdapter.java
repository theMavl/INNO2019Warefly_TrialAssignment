package com.example.warefly_trialassignment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.warefly_trialassignment.R;
import com.example.warefly_trialassignment.data.Ingredient;

import java.util.ArrayList;

public class IngredientsAdapter extends ArrayAdapter<Ingredient> {
    public IngredientsAdapter(Context context, ArrayList<Ingredient> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Ingredient ingredient = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ingredient_list_item, parent, false);
        }
        TextView tvName = convertView.findViewById(R.id.ingredient);
        TextView tvHome = convertView.findViewById(R.id.value);
        tvName.setText(ingredient.name);
        tvHome.setText(ingredient.value);
        return convertView;
    }


}