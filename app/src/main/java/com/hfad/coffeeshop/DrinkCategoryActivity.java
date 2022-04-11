package com.hfad.coffeeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

//        ArrayAdapter is used to get data from a java file if we don't want to get data from a static
//        string resource created in strings.xml file.
        ArrayAdapter<Drink> drinkArrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, Drink.drinks
        );

        ListView drinksListView = (ListView) findViewById(R.id.drinks_list);
        drinksListView.setAdapter(drinkArrayAdapter);

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
                intent.putExtra(DrinkActivity.EXTRA_DRINKID, (int) l);
                startActivity(intent);
            }
        };
        drinksListView.setOnItemClickListener(onItemClickListener);
    }
}