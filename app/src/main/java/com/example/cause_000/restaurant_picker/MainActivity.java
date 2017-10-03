package com.example.cause_000.restaurant_picker;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

//First App Made by: Conner Caprio
//6/11/2017

//ideas to add:
//drop down for food category ie: mexican italian cheap fastfood
//based off open times and weekly specials
//spinner or drop down to go to activity instead of button

public class MainActivity extends AppCompatActivity {

    MyDBHandler dbHandler;
    EditText connersInput;
    TextView connersText;
    List<String> restaurants;
    int first = 0;
    //int size = dbHandler.getSize();
    int size;

    //switching to other activity
        public void switchActivity (View view) {
            startActivity(new Intent(MainActivity.this, Activity_Picker.class));
        }

    @Override
    public View findViewById(@IdRes int id) {
        return super.findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connersInput = (EditText) findViewById(R.id.connersInput);
        //connersText = (TextView) findViewById(R.id.connersText); put in later maybe?
        dbHandler = new MyDBHandler(this, null, null, 1);


        /*
        this.addToListManual("Marco and Luca's");
        this.addToListManual("Hunan King");
        this.addToListManual("Chipotle");
        this.addToListManual("Zeppoli's");
        this.addToListManual("The Beast Of Blacksburg");
        this.addToListManual("Macado's");
        this.addToListManual("Subway");
        this.addToListManual("Little Ceasars");
        this.addToListManual("Panera Bread");
        this.addToListManual("Kobe Express");
        this.addToListManual("Firehouse Subs");
        this.addToListManual("Preston's");
        this.addToListManual("Lefty's");
        this.addToListManual("Benny's");
        this.addToListManual("Due South");
        this.addToListManual("Wendy's");
        this.addToListManual("Dominoes");
        this.addToListManual("Jimmy Johns");
        this.addToListManual("Papa Johns");
        this.addToListManual("Pizza Hut");
        this.addToListManual("D.P. Dough");
        this.addToListManual("Moes");
        this.addToListManual("Cabo Fish Taco");
        this.addToListManual("Buffalo Wild Wings");
        this.addToListManual("1000 Degree Pizza");
        this.addToListManual("Wicked Taco");
        this.addToListManual("Blacksburg Taphouse");
        this.addToListManual("Applebees");
        this.addToListManual("Red Robin");
        this.addToListManual("IHOP");
        this.addToListManual("Chik-fil-a");
        this.addToListManual("PK's");
        this.addToListManual("Souvlaki");
        this.addToListManual("Our Daily Bread");
        this.addToListManual("Cinebowl");
        this.addToListManual("Bagel");
        this.addToListManual("Sub Station");
        this.addToListManual("Green's");
        this.addToListManual("Social House");
        this.addToListManual("Happy Wok");
        this.addToListManual("Abby's");
        this.addToListManual("Hokie House");
        this.addToListManual("Zaxby's");
        this.addToListManual("Waffle House");
        this.addToListManual("TOTS");
        this.addToListManual("Mellow Mushroom");
        this.addToListManual("Italianos");
        this.addToListManual("Zoe's Kitchen");
        this.addToListManual("Underground Pub");
        this.addToListManual("Cook Out");
        this.addToListManual("Roma Pizza");
        this.addToListManual("Sake House");
        this.addToListManual("Bojangles");
        this.addToListManual("El Mariachi");
        this.addToListManual("Burger 37");
        this.addToListManual("HWY 55");
        this.addToListManual("Bull and Bones");
        this.addToListManual("Olive Garden");
        this.addToListManual("Outback");
        this.addToListManual("Hardee's");
        this.addToListManual("Panda Express");
        this.addToListManual("Champs");
        this.addToListManual("NomNoms");
        this.addToListManual("Golden Corral");
        this.addToListManual("Big Al's");
        this.addToListManual("Poor Billy's");
        this.addToListManual("Black Hen");
        this.addToListManual("Boudreaux's");
        */



        dbHandler.listMaker();
        restaurants = dbHandler.getList();
        size = dbHandler.getSize();
    }

    public void picker(View view) {

        if (size <= 0) {
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText("All Out :'(");
            return;
        }
            /*
            florida list

            //size = 60
            this.addToListManual("Bar Fly");
            this.addToListManual("Whitsle Stop");
            this.addToListManual("Safety Harbor Pizza");
            this.addToListManual("Burger Monger");
            this.addToListManual("Jimmy Johns");
            this.addToListManual("Pizza Hut");
            this.addToListManual("Wok n Rol");
            this.addToListManual("Einsteins");
            this.addToListManual("Bonefish");
            this.addToListManual("Anthonys");
            this.addToListManual("Beef o Bradys");
            this.addToListManual("Subway");
            this.addToListManual("Marcos Pizza");
            this.addToListManual("Pickles Plus");
            this.addToListManual("Louis Papas");
            this.addToListManual("Jersey Mikes");
            this.addToListManual("Checkers");
            this.addToListManual("Johnnys");
            this.addToListManual("Applebees");
            this.addToListManual("8th Avenue Pub");
            this.addToListManual("Boston Market");
            this.addToListManual("Chik fil A");
            this.addToListManual("Chillis");
            this.addToListManual("Red Lobster");
            this.addToListManual("Country Pizza Inn");
            this.addToListManual("Cody's Roadhouse");
            this.addToListManual("Moes");
            this.addToListManual("chipotle");
            this.addToListManual("Grillsmith");
            this.addToListManual("First Watch");
            this.addToListManual("Red Robin");
            this.addToListManual("PF Changs");
            this.addToListManual("Grimaldies");
            this.addToListManual("BJ's");
            this.addToListManual("Panera Bread");
            this.addToListManual("Tijuanna Flats");
            this.addToListManual("Greek City");
            this.addToListManual("Steak n Shake");
            this.addToListManual("Olive Garden");
            this.addToListManual("Kobes");
            this.addToListManual("Hooters");
            this.addToListManual("Winghouse");
            this.addToListManual("Mellow Mushroom");
            this.addToListManual("Legends");
            this.addToListManual("Buffalo Wild Wings");
            this.addToListManual("Ruby Tuesdays");
            this.addToListManual("Craft Street Kitchen");
            this.addToListManual("Rumba");
            this.addToListManual("Sald Rock Tavern");
            this.addToListManual("Flamestone");
            this.addToListManual("Dunedin Place");
            this.addToListManual("Frenchys");
            this.addToListManual("Palm Pavilion");
            this.addToListManual("Red Mesa");
            this.addToListManual("Jack Willies");
            this.addToListManual("Smokey Bones");
            this.addToListManual("Outback");
            this.addToListManual("Brick House");
            this.addToListManual("Carrabas");
            this.addToListManual("Local Brewing Company");
            */

        Random random = new Random();
        int number = random.nextInt(size);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(restaurants.remove(number));
        size--;
    }

    public void addToList(View view) {
        //Items item = new Items(connersInput.getText().toString());
        //dbHandler.addItem(item);
        //restaurants.add(connersInput.getText().toString());
        //size++;
        this.addToListManual(connersInput.getText().toString());
    }
    
    public void addToListManual(String string){
        Items item = new Items(string);
        dbHandler.addItem(item);
        size++;
    }

    public  void updateList() {
        restaurants = dbHandler.getList();
    }

    public void clearDatabase(View view) {
        dbHandler.clearDatabase();
        this.resetList();
    }

    public void resetList() {
        dbHandler.onCreateTwo();
    }
}
