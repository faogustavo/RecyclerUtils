package com.gustavofao.recyclerutils.Model;

import android.view.View;

/**
 * Created by Gustavo Fão Valvassori on 16/02/16.
 * Propósito:
 */
public class BaseModel {

    protected int imageRes;

    protected String title;
    protected String subTitle;

    protected CharSequence imageURL;

    protected View.OnClickListener onClickListener;

    public BaseModel(String title) {
        this.title = title;
        this.subTitle = null;

        this.imageRes = -1;
        this.imageURL = null;
    }

    public BaseModel(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;

        this.imageRes = -1;
        this.imageURL = null;
    }

    public BaseModel(String title, int imageRes) {
        this.title = title;
        this.subTitle = null;

        this.imageRes = imageRes;
        this.imageURL = null;
    }

    public BaseModel(String title, CharSequence imageURL) {
        this.title = title;
        this.subTitle = null;

        this.imageRes = -1;
        this.imageURL = imageURL;
    }

    public BaseModel(String title, String subTitle, int imageRes) {
        this.title = title;
        this.subTitle = subTitle;

        this.imageRes = imageRes;
        this.imageURL = null;
    }

    public BaseModel(String title, String subTitle, CharSequence imageURL) {
        this.title = title;
        this.subTitle = subTitle;

        this.imageRes = -1;
        this.imageURL = imageURL;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getImageURL() {
        if (imageURL != null)
            return imageURL.toString();
        return null;
    }

    public void setImageURL(CharSequence imageURL) {
        this.imageURL = imageURL;
    }

    public boolean hasImage() {
        return (this.imageRes > 0 || this.imageURL != null);
    }

    public boolean hasSubtitle() {
        return (this.subTitle != null);
    }

    public boolean isImageFromURL() {
        if (!hasImage()) return false;
        return this.imageURL != null;
    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
