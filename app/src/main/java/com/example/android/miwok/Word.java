package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Word extends AppCompatActivity {
private String mDefaultTranslation;
    private String mPediTranslation;
  private int mImageResourcedId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;



    public Word(String defaultTranslation, String pediTranslation){

        mDefaultTranslation = defaultTranslation;
        mPediTranslation = pediTranslation;
    }


    public Word(String defaultTranslation, String pediTranslation, int imageResourceId){

        mDefaultTranslation = defaultTranslation;
        mPediTranslation = pediTranslation;
        mImageResourcedId = imageResourceId;
    }

    public String getmDefaultTranslation(){

        return mDefaultTranslation;
    }

    public String getmPediTranslation(){

        return  mPediTranslation;
    }
   public int getImageResourcedId(){

       return mImageResourcedId;
    }

    public boolean hasImage(){

        return mImageResourcedId != NO_IMAGE_PROVIDED;
    }
}
