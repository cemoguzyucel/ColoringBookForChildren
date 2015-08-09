package com.wish.coloringbookforchildren.customviews;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wish.coloringbookforchildren.R;
import com.wish.coloringbookforchildren.models.Category;
import com.wish.coloringbookforchildren.models.ColoringImage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cemoguzyucel on 09/08/15.
 */
public class DetailedCategoryView extends BaseAdapter{

    private Context mContext;
    private List<ColoringImage> coloringImages = new ArrayList<ColoringImage>();


    public DetailedCategoryView(Context c, List<ColoringImage> coloringImages) {
        mContext = c;
        this.coloringImages = coloringImages;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 6;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View listView;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            listView = new View(mContext);
            listView = inflater.inflate(R.layout.detailed_category_row, null);
            ImageView imageLeft = (ImageView) listView.findViewById(R.id.imageViewLeft);
            ImageView imageRight = (ImageView) listView.findViewById(R.id.imageViewRight);

            imageLeft.setImageResource(R.drawable.technology_001);
            imageRight.setImageResource(R.drawable.technology_002);



        } else {
            listView = (View) convertView;
        }

        return listView;
    }
}
