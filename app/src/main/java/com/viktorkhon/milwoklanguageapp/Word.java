package com.viktorkhon.milwoklanguageapp;

/**
 * Created by Viktor Khon on 7/5/2017.
 */

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImage;

    public Word(String defaultTranslation, String miwokTranslation) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int image) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImage = image;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public int getImage() {
        return mImage;
    }

    public boolean hasImage() {
        if (mImage <= 0) {
            return false;
        }
        return true;
    }
}
