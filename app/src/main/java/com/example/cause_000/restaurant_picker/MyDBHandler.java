package com.example.cause_000.restaurant_picker;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import java.util.ArrayList;
import java.util.List;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Restaurant_List.db"; //.db tells android file type
    private static final String TABLE_ITEMS = "restaurants"; //is the title of the table?
    private static final String COLUMN_ID = "_id"; //is the column for the id of the item in this case the number it was inputed as (later put in id for location in store)
    private static final String COLUMN_ITEMNAME = "itemName"; //is the column for the id of the item in this case the grocery item ie: bagels

    List<String> restaurants = new ArrayList<String>(); //list is for editing without changing database
    int size = 0;


    // contructor is for super class behind the scenes shit
    //context and factory is behind the scenes stuff
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_ITEMS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_ITEMNAME + " TEXT " +
                ")";

        db.execSQL(query); //makes table made above on create
    }

    public void onCreateTwo() {
        this.addToListAndDbFirst("Zeppoli's");
        this.addToListAndDbFirst("The Beast Of Blacksburg");
        this.addToListAndDbFirst("Macado's");
        this.addToListAndDbFirst("Subway");
        this.addToListAndDbFirst("Little Ceasars");
        this.addToListAndDbFirst("Panera Bread");
        this.addToListAndDbFirst("Kobe Express");
        this.addToListAndDbFirst("Firehouse Subs");
        this.addToListAndDbFirst("Preston's");
        this.addToListAndDbFirst("Lefty's");
        this.addToListAndDbFirst("Benny's");
        this.addToListAndDbFirst("Due South");
        this.addToListAndDbFirst("Wendy's");
        this.addToListAndDbFirst("Dominoes");
        this.addToListAndDbFirst("Jimmy Johns");
        this.addToListAndDbFirst("Papa Johns");
        this.addToListAndDbFirst("Pizza Hut");
        this.addToListAndDbFirst("D.P. Dough");
        this.addToListAndDbFirst("Moes");
        this.addToListAndDbFirst("Cabo Fish Taco");
        this.addToListAndDbFirst("Buffalo Wild Wings");
        this.addToListAndDbFirst("1000 Degree Pizza");
        this.addToListAndDbFirst("Wicked Taco");
        this.addToListAndDbFirst("Blacksburg Taphouse");
        this.addToListAndDbFirst("Applebees");
        this.addToListAndDbFirst("Red Robin");
        this.addToListAndDbFirst("IHOP");
        this.addToListAndDbFirst("Chik-fil-a");
        this.addToListAndDbFirst("PK's");
        this.addToListAndDbFirst("Souvlaki");
        this.addToListAndDbFirst("Our Daily Bread");
        this.addToListAndDbFirst("Cinebowl");
        this.addToListAndDbFirst("Bagel");
        this.addToListAndDbFirst("Sub Station");
        this.addToListAndDbFirst("Green's");
        this.addToListAndDbFirst("Social House");
        this.addToListAndDbFirst("Happy Wok");
        this.addToListAndDbFirst("Abby's");
        this.addToListAndDbFirst("Hokie House");
        this.addToListAndDbFirst("Zaxby's");
        this.addToListAndDbFirst("Waffle House");
        this.addToListAndDbFirst("TOTS");
        this.addToListAndDbFirst("Mellow Mushroom");
        this.addToListAndDbFirst("Italianos");
        this.addToListAndDbFirst("Zoe's Kitchen");
        this.addToListAndDbFirst("Underground Pub");
        this.addToListAndDbFirst("Cook Out");
        this.addToListAndDbFirst("Roma Pizza");
        this.addToListAndDbFirst("Sake House");
        this.addToListAndDbFirst("Bojangles");
        this.addToListAndDbFirst("El Mariachi");
        this.addToListAndDbFirst("Burger 37");
        this.addToListAndDbFirst("HWY 55");
        this.addToListAndDbFirst("Bull and Bones");
        this.addToListAndDbFirst("Olive Garden");
        this.addToListAndDbFirst("Outback");
        this.addToListAndDbFirst("Hardee's");
        this.addToListAndDbFirst("Panda Express");
        this.addToListAndDbFirst("Champs");
        this.addToListAndDbFirst("NomNoms");
        this.addToListAndDbFirst("Golden Corral");
        this.addToListAndDbFirst("Big Al's");
        this.addToListAndDbFirst("Poor Billy's");
        this.addToListAndDbFirst("Black Hen");
        this.addToListAndDbFirst("Boudreaux's");
        this.addToListAndDbFirst("Marco and Luca's");
        this.addToListAndDbFirst("Hunan King");
        this.addToListAndDbFirst("Chipotle");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_ITEMS);
        onCreate(db); //makes new table
    }

    //add new row to database
    public void addItem(Items item) {
        ContentValues values = new ContentValues(); //allows inserting stuff really easy
        values.put(COLUMN_ITEMNAME, item.get_itemName());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_ITEMS, null, values); //inserts new item into table
        db.close(); //closes file to let android know it can use it again

        restaurants.add(item.get_itemName());
        size++;
    }
    
    //this is for adding the lots of shit only first time making db
    private void addToListAndDbFirst(String string){
        ContentValues values = new ContentValues(); //allows inserting stuff really easy
        values.put(COLUMN_ITEMNAME, string);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_ITEMS, null, values); //inserts new item into table
        db.close(); //closes file to let android know it can use it again
    }

    //delete an item from the database
    public void deleteItem(String itemName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(" DELETE FROM " + TABLE_ITEMS + " WHERE " + COLUMN_ITEMNAME + "=\"" + itemName + "\";"); //deletes if the name is the same name
    }

    //prints out the database as a string
    public String databseToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = " SELECT * FROM " + TABLE_ITEMS + " WHERE 1";

        //cursor points to a location in your results
        //easier for android to manage shit
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst(); //moves cursor to first row in your results

        while (!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex("itemName")) != null){ //makes sure not in last row
                dbString += c.getString(c.getColumnIndex("itemName"));
                dbString += "\n"; //makes an item on different lines
            }
            c.moveToNext();
        }
        db.close();
        return dbString;

    }

    public void clearDatabase() {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_ITEMS, null, null);
        this.onCreateTwo();

    }

    public void listMaker() {
        String names = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = " SELECT * FROM " + TABLE_ITEMS + " WHERE 1";

        //cursor points to a location in your results
        //easier for android to manage shit
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst(); //moves cursor to first row in your results

        while (!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex("itemName")) != null){ //makes sure not in last row
                names = c.getString(c.getColumnIndex("itemName"));
            }
            c.moveToNext();
            restaurants.add(names);
            size++;
        }
        db.close();
    }

    public int getSize() {
        return size;
    }

    public List<String> getList() {
        return restaurants;
    }



}
