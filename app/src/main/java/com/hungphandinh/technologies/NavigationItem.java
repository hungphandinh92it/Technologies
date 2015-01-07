package com.hungphandinh.technologies;

import android.graphics.drawable.Drawable;

/**
 * Created by hungphandinh on 30-Dec-14.
 */
public class NavigationItem {
    private String mText;
    private Drawable mDrawable;

    public NavigationItem(String mText, Drawable mDrawable) {
        this.mText = mText;
        this.mDrawable = mDrawable;
    }

    public void setDrawable(Drawable mDrawable) {
        this.mDrawable = mDrawable;
    }

    public Drawable getDrawable() {
        return mDrawable;
    }

    public void setText(String mText) {
        this.mText = mText;
    }

    public String getText() {
        return mText;
    }
}
