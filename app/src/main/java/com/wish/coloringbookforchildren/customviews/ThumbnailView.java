package com.wish.coloringbookforchildren.customviews;

/**
 * Created by cemoguzyucel on 19/07/15.
 */
import android.content.Context;
import android.media.Image;
import android.util.Log;
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

public class ThumbnailView extends BaseAdapter{
    private Context mContext;
    private List<Category> categories = new ArrayList<Category>();

    private List<ColoringImage> coloringImages = new ArrayList<ColoringImage>();
    private List<ColoringImage> coloringImagesByCategory = new ArrayList<ColoringImage>();

    private List<ColoringImage> coloringImagesPreviews = new ArrayList<ColoringImage>();



    public ThumbnailView(Context c, List<Category> categories,
                         List<ColoringImage> coloringImages) {
        mContext = c;
        this.categories = categories;
        this.coloringImages = coloringImages;


    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return categories.size();
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

    public List<ColoringImage> narrowByCategory(List <ColoringImage> coloringImages,String category){

            for (ColoringImage coloringImage : coloringImages) {
                if(coloringImage.getCategory().getCategoryName().equals(category)){
                    coloringImagesByCategory.add(coloringImage);
                }
            }


        return coloringImagesByCategory;
    }

    public List<ColoringImage> setColoringImagePreviews(String currentCategoryName){
        //parametre olarak category alacak
        //add işlemini yaparken categoriye göre yapmalı

        coloringImagesByCategory = narrowByCategory(coloringImages,currentCategoryName);

        Random rand = new Random();
        List<Integer> randomNumberList= new ArrayList<Integer>();
        int randomNumber=-1;
        int i=0;
        while(i<4){
            randomNumber = rand.nextInt(coloringImagesByCategory.size());

            if(!randomNumberList.contains(randomNumber)){
                randomNumberList.add(randomNumber);
                coloringImagesPreviews.add(coloringImagesByCategory.get(randomNumber));
                i++;
            }
        }
        return coloringImagesPreviews;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.layout_thumbnail_view, null);
            TextView textView = (TextView) grid.findViewById(R.id.category_name);
            textView.setText(categories.get(position).getCategoryName());
            RelativeLayout relativeLayout = (RelativeLayout) grid.findViewById(R.id.category_group);
            String currentCategoryName = categories.get(position).getCategoryName();

            ImageView imageView1 = (ImageView)grid.findViewById(R.id.sample_image1);
            ImageView imageView2 = (ImageView)grid.findViewById(R.id.sample_image2);
            ImageView imageView3 = (ImageView)grid.findViewById(R.id.sample_image3);
            ImageView imageView4 = (ImageView)grid.findViewById(R.id.sample_image4);


            coloringImagesPreviews = setColoringImagePreviews(currentCategoryName);



            imageView1.setImageResource(coloringImagesPreviews.get(0).getColoringImageId());
            imageView2.setImageResource(coloringImagesPreviews.get(1).getColoringImageId());
            imageView3.setImageResource(coloringImagesPreviews.get(2).getColoringImageId());
            imageView4.setImageResource(coloringImagesPreviews.get(3).getColoringImageId());

            coloringImagesPreviews.clear();

        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
