package com.wish.coloringbookforchildren.applicationdata;

import android.content.Context;

import com.wish.coloringbookforchildren.models.Category;
import com.wish.coloringbookforchildren.models.ColoringImage;

import java.util.List;

/**
 * Created by cemoguzyucel on 09/08/15.
 */
public class ApplicationDataProvider {


    private static ApplicationDataProvider instance = null;
    public ApplicationDataProvider() {
        // Exists only to defeat instantiation.
    }
    public static ApplicationDataProvider getInstance() {
        if(instance == null) {
            instance = new ApplicationDataProvider();
        }
        return instance;
    }

    Context mContext;

    List<Category> workingCategories;
    List<ColoringImage> workingColoringImages;
    Category workingCategory;

/*
    public ApplicationDataProvider(Context mContext){
        this.mContext = mContext;2
    }
*/

    public List<Category> getWorkingCategories() {
        return workingCategories;
    }

    public void setWorkingCategories(List<Category> workingCategories) {
        this.workingCategories = workingCategories;
    }

    public List<ColoringImage> getWorkingColoringImages() {
        return workingColoringImages;
    }

    public void setWorkingColoringImages(List<ColoringImage> workingColoringImages) {
        this.workingColoringImages = workingColoringImages;
    }

    public Category getWorkingCategory() {
        return workingCategory;
    }

    public void setWorkingCategory(Category workingCategory) {
        this.workingCategory = workingCategory;
    }
}
