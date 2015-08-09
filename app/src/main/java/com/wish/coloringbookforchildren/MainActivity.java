package com.wish.coloringbookforchildren;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.wish.coloringbookforchildren.activities.DetailedCategoryActivity;
import com.wish.coloringbookforchildren.customviews.ThumbnailView;
import com.wish.coloringbookforchildren.models.Category;
import com.wish.coloringbookforchildren.models.ColoringImage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Variables
    GridView selectCategoryGridView;
    GridView categoryGrid;
    List<Category> categories = new ArrayList<Category>();
    List<ColoringImage> coloringImages = new ArrayList<ColoringImage>();



    Category animals;
    Category fruits;
    Category superheroes;
    Category sport;
    Category flags;
    Category countries;
    Category cars;
    Category planes;
    Category houses;
    Category cartoon;
    Category technology;
    Category science_fiction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animals = new Category(getString(R.string.animals));
        fruits = new Category(getString(R.string.fruits));
        superheroes = new Category(getString(R.string.superheroes));
        sport = new Category(getString(R.string.sport));
        flags = new Category(getString(R.string.flags));
        countries = new Category(getString(R.string.countries));
        cars = new Category(getString(R.string.cars));
        planes = new Category(getString(R.string.planes));
        houses = new Category(getString(R.string.houses));
        cartoon = new Category(getString(R.string.cartoon));
        technology = new Category(getString(R.string.technology));
        science_fiction = new Category(getString(R.string.houses));

        categories = populateCategories();
        coloringImages = populateColoringImages ();



        // Creating database and table

        /*SQLiteDatabase db=openOrCreateDatabase("ColoringDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS categories(categoryName VARCHAR);");*/



        //category isimleri ve iconları
        ThumbnailView adapter = new ThumbnailView(MainActivity.this, categories, coloringImages);

        categoryGrid=(GridView)findViewById(R.id.gridview_categories);
        categoryGrid.setAdapter(adapter);
        categoryGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent myIntent = new Intent(MainActivity.this, DetailedCategoryActivity.class);
                MainActivity.this.startActivity(myIntent);


                //todo
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
 /*           case R.id.button_select_category:
                Intent myIntent = new Intent(MainActivity.this, DetailedCategoryActivity.class);
*//*
                myIntent.putExtra("key", value); //Optional parameters
*//*
                MainActivity.this.startActivity(myIntent);
                break;*/



        }
    }

    public List<Category> populateCategories(){

        List<Category> categories = new ArrayList<Category>();



        categories.add(animals);
        categories.add(fruits);
/*        categories.add(superheroes);
        categories.add(sport);
        categories.add(flags);
        categories.add(countries);
        categories.add(cars);
        categories.add(planes);
        categories.add(houses);
        categories.add(cartoon);
        categories.add(technology);
        categories.add(science_fiction);*/

        //categories should be sorted according to element.getCategoryName

        return categories;

    }


    public List<ColoringImage> populateColoringImages(){

        List<ColoringImage> coloringImages = new ArrayList<ColoringImage>();

        ColoringImage imageExample1 = new ColoringImage(animals,"wolf",R.drawable.icon_small1,null);
        ColoringImage imageExample2 = new ColoringImage(animals,"clown",R.drawable.icon_small2,null);
        ColoringImage imageExample3 = new ColoringImage(animals,"penguin",R.drawable.icon_small3,null);
        ColoringImage imageExample4 = new ColoringImage(animals,"turtle",R.drawable.icon_small4,null);
        ColoringImage imageExample5 = new ColoringImage(fruits,"penguin1",R.drawable.penguin_small,null);
        ColoringImage imageExample6 = new ColoringImage(fruits,"penguin2",R.drawable.penguin_small,null);
        ColoringImage imageExample7 = new ColoringImage(fruits,"penguin3",R.drawable.icon_small5,null);
        ColoringImage imageExample8 = new ColoringImage(fruits,"penguin4",R.drawable.folder_icon,null);

        coloringImages.add(imageExample1);
        coloringImages.add(imageExample2);
        coloringImages.add(imageExample3);
        coloringImages.add(imageExample4);
        coloringImages.add(imageExample5);
        coloringImages.add(imageExample6);
        coloringImages.add(imageExample7);
        coloringImages.add(imageExample8);
        return coloringImages;
    }



}
