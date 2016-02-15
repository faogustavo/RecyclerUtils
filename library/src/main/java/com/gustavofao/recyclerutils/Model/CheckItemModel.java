package com.gustavofao.recyclerutils.Model;

import android.content.SharedPreferences;
import android.view.View;

import com.gustavofao.recyclerutils.Interfaces.OnValueChange;

/**
 * Created by Gustavo Fão Valvassori on 13/02/16.
 * Propósito: Gerenciar os dados do CheckItemViewHolder
 */
public class CheckItemModel {

    private int imageRes;

    private String title;
    private String subTitle;
    private String imageURL;
    private String sharedPreferencesKey;

    private boolean useImage;
    private boolean useImageFromURL;
    private boolean useSubTitle;
    private boolean useSharedPreferences;
    private boolean defaultValue;
    private boolean currentValue;

    private SharedPreferences preferences;
    private OnValueChange<Boolean> onCheckValueChange;
    private View.OnClickListener onClickListener;

    public CheckItemModel(String title) {
        this.title = title;

        this.imageRes = -1;
        this.useImage = false;

        this.imageURL = null;
        this.useImageFromURL = false;

        this.subTitle = null;
        this.useSubTitle = false;

        this.sharedPreferencesKey = null;
        this.useSharedPreferences = false;

        this.defaultValue = false;
        this.currentValue = defaultValue;
    }

    public CheckItemModel(String title, int imageRes) {
        this.title = title;

        this.imageRes = imageRes;
        this.useImage = true;

        this.imageURL = null;
        this.useImageFromURL = false;

        this.subTitle = null;
        this.useSubTitle = false;

        this.sharedPreferencesKey = null;
        this.useSharedPreferences = false;

        this.defaultValue = false;
        this.currentValue = defaultValue;
    }

    public CheckItemModel(String title, CharSequence imageURL) {
        this.title = title;

        this.imageRes = -1;
        this.useImage = true;

        this.imageURL = imageURL.toString();
        this.useImageFromURL = true;

        this.subTitle = null;
        this.useSubTitle = false;

        this.sharedPreferencesKey = null;
        this.useSharedPreferences = false;

        this.defaultValue = false;
        this.currentValue = this.defaultValue;
    }

    public CheckItemModel(String title, String subtitle) {
        this.title = title;

        this.imageRes = -1;
        this.useImage = false;

        this.imageURL = null;
        this.useImageFromURL = false;

        this.subTitle = subtitle;
        this.useSubTitle = true;

        this.sharedPreferencesKey = null;
        this.useSharedPreferences = false;

        this.defaultValue = false;
        this.currentValue = this.defaultValue;
    }

    public CheckItemModel(String title, String subtitle, int imageRes) {
        this.title = title;

        this.imageRes = imageRes;
        this.useImage = true;

        this.imageURL = null;
        this.useImageFromURL = false;

        this.subTitle = subtitle;
        this.useSubTitle = true;

        this.sharedPreferencesKey = null;
        this.useSharedPreferences = false;

        this.defaultValue = false;
        this.currentValue = this.defaultValue;
    }

    public CheckItemModel(String title, String subtitle, CharSequence imageURL) {
        this.title = title;

        this.imageRes = -1;
        this.useImage = true;

        this.imageURL = imageURL.toString();
        this.useImageFromURL = true;

        this.subTitle = subtitle;
        this.useSubTitle = true;

        this.sharedPreferencesKey = null;
        this.useSharedPreferences = false;

        this.defaultValue = false;
        this.currentValue = this.defaultValue;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
        this.useImage = imageRes > 0;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
        this.useSubTitle = subTitle != null;
    }

    public boolean getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(boolean defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(boolean currentValue) {
        this.currentValue = currentValue;
    }

    public OnValueChange<Boolean> getOnValueChange() {
        return onCheckValueChange;
    }

    public void setOnValueChange(OnValueChange<Boolean> onCheckValueChange) {
        this.onCheckValueChange = onCheckValueChange;
    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
        this.useImage = true;
        this.useImageFromURL = true;
    }

    public String getSharedPreferencesKey() {
        return sharedPreferencesKey;
    }

    public boolean isUsingSharedPreferences() {
        return useSharedPreferences;
    }

    public boolean isUsingImage() {
        return useImage;
    }

    public boolean isUsingImageFromURL() {
        return useImageFromURL;
    }

    public boolean isUsingSubTitle() {
        return useSubTitle;
    }

    public void withSharedPreferences(SharedPreferences preferences, String sharedPreferencesKey) {
        this.useSharedPreferences = true;
        this.preferences = preferences;
        this.sharedPreferencesKey = sharedPreferencesKey;

        this.defaultValue = preferences.getBoolean(sharedPreferencesKey, this.defaultValue);
        this.currentValue = this.defaultValue;
    }

    public void applyChanges() {
        if (!useSharedPreferences) return;
        this.preferences.edit()
                .putBoolean(this.sharedPreferencesKey, this.currentValue)
                .commit();
    }
}
