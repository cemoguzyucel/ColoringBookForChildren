package com.wish.coloringbookforchildren.applicationdata;

import android.content.Context;

import com.wish.coloringbookforchildren.R;
import com.wish.coloringbookforchildren.models.Category;
import com.wish.coloringbookforchildren.models.ColoringImage;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by cemoguzyucel on 09/08/15.
 */
public class ApplicationDataInitializer {

    //Buralar Singleton Tanımlanacak

    Context mContext;
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

    public ApplicationDataInitializer(Context mContext){
        this.mContext = mContext;
    }

    public List<ColoringImage> populateColoringImages(){
        // her category için uygun imagelar burada eklenecek
        //test2 test6


        List<ColoringImage> coloringImages = new ArrayList<ColoringImage>();

        ColoringImage imageExample1 = new ColoringImage(technology,"technology_001", R.drawable.technology_001,null);
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

    public List<Category> populateCategories(){

        List<Category> categories = new ArrayList<Category>();
        animals = new Category(mContext.getResources().getString(R.string.animals));
        fruits = new Category(mContext.getResources().getString(R.string.fruits));
        superheroes = new Category(mContext.getResources().getString(R.string.superheroes));
        sport = new Category(mContext.getResources().getString(R.string.sport));
        flags = new Category(mContext.getResources().getString(R.string.flags));
        countries = new Category(mContext.getResources().getString(R.string.countries));
        cars = new Category(mContext.getResources().getString(R.string.cars));
        planes = new Category(mContext.getResources().getString(R.string.planes));
        houses = new Category(mContext.getResources().getString(R.string.houses));
        cartoon = new Category(mContext.getResources().getString(R.string.cartoon));
        technology = new Category(mContext.getResources().getString(R.string.technology));
        science_fiction = new Category(mContext.getResources().getString(R.string.houses));


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


}
