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

import java.io.Serializable;
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
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("coloringImage", (Serializable) coloringImages);
                myIntent.putExtras(mBundle);
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



/*
        categories.add(animals);
*/
/*        categories.add(fruits); */
        categories.add(technology);
/*        categories.add(superheroes);
        categories.add(sport);
        categories.add(flags);
        categories.add(countries);
        categories.add(cars);
        categories.add(planes);
        categories.add(houses);
        categories.add(cartoon);
        categories.add(science_fiction);*/

        //categories should be sorted according to element.getCategoryName

        return categories;

    }


    public List<ColoringImage> populateColoringImages(){

        List<ColoringImage> coloringImages = new ArrayList<ColoringImage>();

        ColoringImage imageExample1 = new ColoringImage(technology,"technology_001",R.drawable.technology_001,null);
        ColoringImage imageExample2 = new ColoringImage(technology,"technology_002",R.drawable.technology_002,null);
        ColoringImage imageExample3 = new ColoringImage(technology,"technology_003",R.drawable.technology_003,null);
        ColoringImage imageExample4 = new ColoringImage(technology,"technology_004",R.drawable.technology_004,null);
        ColoringImage imageExample5 = new ColoringImage(technology,"technology_005",R.drawable.technology_005,null);
        ColoringImage imageExample6 = new ColoringImage(technology,"technology_006",R.drawable.technology_006, null);

        coloringImages.add(imageExample1);
        coloringImages.add(imageExample2);
        coloringImages.add(imageExample3);
        coloringImages.add(imageExample4);
        coloringImages.add(imageExample5);
        coloringImages.add(imageExample6);
        return coloringImages;
    }



}
