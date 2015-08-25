package com.wish.coloringbookforchildren;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.wish.coloringbookforchildren.activities.DetailedCategoryActivity;
import com.wish.coloringbookforchildren.applicationdata.ApplicationDataProvider;
import com.wish.coloringbookforchildren.customviews.ThumbnailView;
import com.wish.coloringbookforchildren.models.Category;
import com.wish.coloringbookforchildren.models.ColoringImage;
import com.wish.coloringbookforchildren.applicationdata.ApplicationDataInitializer;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Variables
    GridView selectCategoryGridView;
    GridView categoryGrid;
    List<Category> categories = new ArrayList<Category>();
    List<ColoringImage> coloringImages = new ArrayList<ColoringImage>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApplicationDataInitializer applicationDataInitializer = new ApplicationDataInitializer(this);
        final ApplicationDataProvider applicationDataProvider = new ApplicationDataProvider();

        //populateCategories
        //populateColoringImages


        categories = applicationDataInitializer.populateCategories();
        ApplicationDataProvider.getInstance().setWorkingCategories(categories);
        coloringImages = applicationDataInitializer.populateColoringImages ();
        ApplicationDataProvider.getInstance().setWorkingColoringImages(coloringImages);




        //category isimleri ve iconları
        ThumbnailView adapter = new ThumbnailView(MainActivity.this, categories, coloringImages);

        categoryGrid=(GridView)findViewById(R.id.gridview_categories);
        categoryGrid.setAdapter(adapter);
        categoryGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                applicationDataProvider.setWorkingCategory(categories.get(position));


                Intent myIntent = new Intent(MainActivity.this, DetailedCategoryActivity.class);
                //bundle yerine, singleton objeler manipule edilecek
/*                Bundle mBundle = new Bundle();
                for(ColoringImage coloringImage : coloringImages){
                    mBundle.putInt(coloringImage.getColoringImageName(),coloringImage.getColoringImageId());
                }
                myIntent.putExtras(mBundle);*/
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

        }
    }








}
