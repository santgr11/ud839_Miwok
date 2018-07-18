package com.example.android.miwok;

public class Word {


    //Default translation of the word
    private String mDefaultTranslation;

    //Miwok translation of the word
    private String mMiwokTranslation;

    //Image to display
    private int mImageResourceId;

    //Sound to display
    private int mSoundResourceId;

    //Value for no image provided
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String defaultTranslation, String miwokTranslation, int imageID, int soundId) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.mImageResourceId = imageID;
        this.mSoundResourceId = soundId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int soundId) {
        this(defaultTranslation, miwokTranslation, NO_IMAGE_PROVIDED, soundId);
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

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getSoundResourceId() {
        return mSoundResourceId;
    }
}
