package com.wish.coloringbookforchildren.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import com.wish.coloringbookforchildren.R;
import com.wish.coloringbookforchildren.applicationdata.ApplicationDataProvider;
import com.wish.coloringbookforchildren.customviews.DetailedCategoryView;
import com.wish.coloringbookforchildren.customviews.ThumbnailView;
import com.wish.coloringbookforchildren.models.ColoringImage;

import java.util.List;

public class DetailedCategoryActivity extends AppCompatActivity implements View.OnClickListener {

    //variables
    ListView detailedCategoryImageListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_category);
        ApplicationDataProvider.getInstance().getWorkingColoringImages();
        ApplicationDataProvider.getInstance().getWorkingCategory();



        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();




        DetailedCategoryView adapter = new DetailedCategoryView(DetailedCategoryActivity.this,ApplicationDataProvider.getInstance().getWorkingColoringImages());

        detailedCategoryImageListView=(ListView)findViewById(R.id.detailed_category_imageListView);
        detailedCategoryImageListView.setAdapter(adapter);
        detailedCategoryImageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent myIntent = new Intent(DetailedCategoryActivity.this, ColoringActivity.class);
                DetailedCategoryActivity.this.startActivity(myIntent);


                //todo
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detailed_category, menu);
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

    }
}
