package com.wish.coloringbookforchildren.models;

import android.widget.ImageView;

/**
 * Created by cemoguzyucel on 20/07/15.
 */
public class ColoringImage {

    //variables
    Category category;
    String coloringImageName;
    int coloringImageId;
    ImageView imageView;


    public ColoringImage(Category category, String coloringImageName, int coloringImageId,ImageView imageView) {
        this.category = category;
        this.coloringImageName = coloringImageName;
        this.coloringImageId = coloringImageId;
        this.imageView = imageView;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getColoringImageName() {
        return coloringImageName;
    }

    public void setColoringImageName(String coloringImageName) {
        this.coloringImageName = coloringImageName;
    }

    public int getColoringImageId() {
        return coloringImageId;
    }

    public void setColoringImageId(int coloringImageId) {
        this.coloringImageId = coloringImageId;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
