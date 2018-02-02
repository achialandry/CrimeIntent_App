package com.bignerdranch.android.criminalintent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by landry on 2018-02-01.
 */

public class PictureUtils {

    public static Bitmap getScaledBitmap(String path, int destWidth, int destHeight){
        //Read in the dimensions of the image on disk
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float scrWidth = options.outWidth;
        float scrHeight = options.outHeight;

        //Figure out how much to scale down by
        int inSampleSize = 1;
        if ( scrHeight > destHeight || scrWidth > destWidth){
            float heightScale = scrHeight / destHeight;
            float widthScale = scrWidth / destWidth;

            inSampleSize = Math.round(heightScale > widthScale ? heightScale : widthScale);
        }

        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;

        //Read in and create file bitmap

        return  BitmapFactory.decodeFile(path, options);
    }
}
