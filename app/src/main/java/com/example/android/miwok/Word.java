package com.example.android.miwok;

public class Word {


    //Default translation of the word
    private String mDefaultTranslation;

    //Miwok translation of the word
    private String mMiwokTranslation;

    //Image to display
    private int mImageResourceId;

    public Word(String defaultTranslation, String miwokTranslation, int imageID) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.mImageResourceId = imageID;
    }

    public Word(String defaultTranslation, String miwokTranslation) {
        this(defaultTranslation, miwokTranslation, 0);
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
