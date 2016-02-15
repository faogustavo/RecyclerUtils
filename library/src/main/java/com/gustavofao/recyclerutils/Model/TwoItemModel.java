package com.gustavofao.recyclerutils.Model;

import android.view.View;

/**
 * Created by Gustavo Fão Valvassori on 13/02/16.
 * Propósito:
 */
public class TwoItemModel {

    private int imageRes;

    private String title;
    private String subTitle;
    private String imageURL;

    private boolean usingImage;
    private boolean imageFromURL;

    private View.OnClickListener onClickListener;

    public TwoItemModel(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
        this.imageURL = null;

        this.usingImage = false;
        this.imageFromURL = false;
    }

    public TwoItemModel(String title, String subTitle, int imageRes) {
        this.imageRes = imageRes;
        this.title = title;
        this.subTitle = subTitle;
        this.usingImage = true;
    }

    public TwoItemModel(String title, String subTitle, CharSequence imageURL) {
        this.title = title;
        this.subTitle = subTitle;
        this.imageURL = imageURL.toString();

        this.usingImage = true;
        this.imageFromURL = true;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
        this.usingImage = true;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public boolean isUsingImage() {
        return usingImage;
    }

    public boolean isUsingImageFromURL() {
        return imageFromURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
        this.usingImage = true;
        this.imageFromURL = true;
    }

    public void setUsingImage(boolean usingImage) {
        this.usingImage = usingImage;
    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
