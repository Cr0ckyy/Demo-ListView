package com.example.demolistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

// Todo: Step 3: Create a CustomAdapter class which extends  from the ArrayAdapter class.
public class FoodAdapter extends ArrayAdapter<Food> {

    private ArrayList<Food> food;
    private Context context;
    private TextView tvFoodName;
    private ImageView ivStar;

    public FoodAdapter(Context context, int resource, ArrayList<Food> objects) {
        super(context, resource, objects);

        // Store the food that is passed to this adapter
        food = objects;

        // Store Context object as we would need to use it later
        this.context = context;
    }

    /*
     Todo: In the getView() method
     Todo: 1.Inflate the View based on the layout customised for each row.
     Todo: 2.Obtain the relevant Views (including the ImageView) via the findViewById() method.
     Todo: 3.Assign the data to the corresponding Views in the row.
     */
    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Todo: Obtain the LayoutInflater object
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Todo: "Inflate" the View for each row
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Todo: Obtain the UI components through binding
        // Get the TextView & ImageView objects
        tvFoodName = (TextView) rowView.findViewById(R.id.tvFoodName);
        ivStar = (ImageView) rowView.findViewById(R.id.ivStar);

        // Todo: Obtain the Android Version information based on the position
        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Food currentFood = food.get(position);


        // Todo: Set values to the TextView to display the corresponding information
        // Set the TextView to show the food
        tvFoodName.setText(currentFood.getName());

        // Set the image to star or no-star accordingly
        if (currentFood.isStar()) {
            ivStar.setImageResource(R.drawable.star);
        } else {
            ivStar.setImageResource(R.drawable.nostar);
        }

        // Return the nicely done up View to the ListView
        return rowView;
    }
}