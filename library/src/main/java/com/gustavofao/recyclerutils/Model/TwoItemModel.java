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

    private boolean usingImage;

    private View.OnClickListener onClickListener;

    public TwoItemModel(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
        this.usingImage = false;
    }

    public TwoItemModel(String title, String subTitle, int imageRes) {
        this.imageRes = imageRes;
        this.title = title;
        this.subTitle = subTitle;
        this.usingImage = true;
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
