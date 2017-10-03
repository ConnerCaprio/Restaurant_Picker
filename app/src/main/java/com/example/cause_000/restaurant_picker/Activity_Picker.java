package com.example.cause_000.restaurant_picker;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Activity_Picker extends Activity {

    public void switchActivity (View view) {
        startActivity(new Intent(Activity_Picker.this, MainActivity.class));
    }

    int first = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
    }


    List<String> activites = new ArrayList<String>();
    int size = 30;


    public void picker(View view) {
        if (size <= 0) {
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText("All Out :'(");
            return;
        }
        if (first == 0) {
            activites.add("River Tubing");
            activites.add("Escape Room");
            activites.add("Poker Tourni");
            activites.add("8 Bit Fiesta / Game night");
            activites.add("Snowboarding");
            activites.add("Hike");
            activites.add("Build Something Dumb");
            activites.add("Biking");
            activites.add("Tennis");
            activites.add("Guitar");
            activites.add("Make an App");
            activites.add("Cook something fancy");
            activites.add("Grill Out");
            activites.add("Pool day");
            activites.add("Corn hole");
            activites.add("Sauna");
            activites.add("Get Swol");
            activites.add("Trivia Night");
            activites.add("Go to Roanoke");
            activites.add("Movies");
            activites.add("Bowling");
            activites.add("Lazer Tag");
            activites.add("Read");
            activites.add("Mall");
            activites.add("BoardGame");
            activites.add("Spikeball");
            //26 choices above
            activites.add("Find a Party");
            activites.add("Skydiving");
            activites.add("Mini Golf");
            activites.add("Fair");
        }



        Random random = new Random();
        int number = random.nextInt(size);
        first++;

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(activites.remove(number));
        size--;
        return;
    }

    public void addToList(View view) {
        EditText newPlace = (EditText) findViewById(R.id.connersInput);
        String newPlaceName = newPlace.getText().toString();
        activites.add(newPlaceName);
        size++;

    }
}
