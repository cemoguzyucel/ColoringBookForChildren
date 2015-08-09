package com.wish.coloringbookforchildren.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.wish.coloringbookforchildren.R;

public class DetailedCategoryActivity extends AppCompatActivity implements View.OnClickListener {

    //variables
    Button startColoringButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_category);

        //obtain views
        startColoringButton = (Button) findViewById(R.id.button_start_coloring);


        //set OnClicks for views
        startColoringButton.setOnClickListener(this);
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
        switch (v.getId()) {
            case R.id.button_start_coloring:
                Intent myIntent = new Intent(DetailedCategoryActivity.this, ColoringActivity.class);
/*
                myIntent.putExtra("key", value); //Optional parameters
*/
                DetailedCategoryActivity.this.startActivity(myIntent);
                break;


        }
    }
}
