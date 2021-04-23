package com.example.demolistview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Todo: Step 2: Declare ArrayList , ArrayAdapter and other variables
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Food> food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Todo: Step 3: Bind variables
        lv = (ListView) this.findViewById(R.id.lvFood);
        food = new ArrayList<>();
        aa = new FoodAdapter(this, R.layout.row, food);

        // Todo: Step 4: Attach the ArrayAdapter to the ListView
        // Link this Activity object, the row.xml layout for
        //  each row and the food String array together
        lv.setAdapter(aa);

        // Todo: Step 5: Update the ListView
        // Create a few food objects in sg.edu.rp.c346.demolistview.Food array
        food.add(new Food("Ah Lat Coffee", false));
        food.add(new Food("Rocky Choc", true));
        food.add(new Food("Kid Cat Choc", true));


        lv.setOnItemClickListener((parent, view, position, id) -> {
            Food selectedFood = food.get(position);

            // Display Toast
            String toastMsg = String.format("%s Star: %b", selectedFood.getName(), selectedFood.isStar());
            Toast.makeText(MainActivity.this, toastMsg, Toast.LENGTH_LONG).show();
        });

    }
}