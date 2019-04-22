package com.example.warefly_trialassignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.warefly_trialassignment.adapters.IngredientsAdapter;
import com.example.warefly_trialassignment.adapters.StepsAdapter;
import com.example.warefly_trialassignment.data.HorizCard;
import com.example.warefly_trialassignment.data.Ingredient;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Молоко 1,5-2%", "200 мл"));
        ingredients.add(new Ingredient("Взбитые сливки", "1 ст. л."));
        ingredients.add(new Ingredient("Карамельный сироп", "3 ч. л."));
        ingredients.add(new Ingredient("Кофе Jacobs Monarch", "1 чашечка"));
        ingredients.add(new Ingredient("Лёд", "2-3 кубика"));

        IngredientsAdapter ingredientsAdapter = new IngredientsAdapter(this, ingredients);

        ListView listView = (ListView) findViewById(R.id.list_ingredients);
        listView.setAdapter(ingredientsAdapter);
        setListViewHeightBasedOnChildren(listView);

        ArrayList<HorizCard> items = new ArrayList<>();
        StepsAdapter stepsAdapter = new StepsAdapter(this, items);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(stepsAdapter);
        for (int i = 0; i < 10; i++) {
            items.add(new HorizCard(R.drawable.cat));
            ingredientsAdapter.notifyDataSetChanged();
        }
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) return;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0) view.setLayoutParams(new
                    ViewGroup.LayoutParams(desiredWidth,
                    ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight + (listView.getDividerHeight() *
                (listAdapter.getCount() - 1));

        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}







