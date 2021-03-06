package com.viktorkhon.milwoklanguageapp;

import android.graphics.drawable.Drawable;

/**
 + * {@link Word} represents a vocabulary word that the user wants to learn.
 + * It contains a default translation and a Miwok translation for that word.
 + */

public class Word {

    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mMiwokTranslation;

    /** image that corresponds to the word */
    private int mImage;

    private int mAudio;

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     * @param audio is the correspondent audio pronunciation for each word
     */
    public Word(String defaultTranslation, String miwokTranslation, int audio) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudio = audio;
        }

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     * @param image is the image that shows the word
     * @param audio is the correspondent audio pronunciation for each word
     */
    public Word(String defaultTranslation, String miwokTranslation, int image, int audio) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImage = image;
        mAudio = audio;
    }

    // Check if there is an image present. Return false if no image ID is found
    // Return true if there is an ID (int)
    public boolean hasImage () {
         if (mImage <=0) {
             return false;
         }
         return true;
    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
   }
    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }
    /**
         * Get the image of the word.
     */
    public int getImage() {
        return mImage;
    }

    public int getAudio() {
        return mAudio;
    }
}
