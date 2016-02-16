package com.gustavofao.recyclerutils.Model;

import android.content.SharedPreferences;
import android.view.View;

import com.gustavofao.recyclerutils.Interfaces.OnValueChange;

/**
 * Created by Gustavo Fão Valvassori on 13/02/16.
 * Propósito: Gerenciar os dados do CheckItemViewHolder
 */
public class CheckItemModel extends BaseModel {

    private String sharedPreferencesKey;
    private boolean useSharedPreferences;

    private boolean defaultValue;
    private boolean currentValue;

    private SharedPreferences preferences;
    private OnValueChange<Boolean> onValueChange;

    public CheckItemModel(String title) {
        super(title);
    }

    public CheckItemModel(String title, String subTitle) {
        super(title, subTitle);
    }

    public CheckItemModel(String title, int imageRes) {
        super(title, imageRes);
    }

    public CheckItemModel(String title, CharSequence imageURL) {
        super(title, imageURL);
    }

    public CheckItemModel(String title, String subTitle, int imageRes) {
        super(title, subTitle, imageRes);
    }

    public CheckItemModel(String title, String subTitle, CharSequence imageURL) {
        super(title, subTitle, imageURL);
    }

    public CheckItemModel(String title, boolean defaultValue) {
        super(title);
        this.defaultValue = defaultValue;
    }

    public CheckItemModel(String title, String subTitle, boolean defaultValue) {
        super(title, subTitle);
        this.defaultValue = defaultValue;
    }

    public CheckItemModel(String title, int imageRes, boolean defaultValue) {
        super(title, imageRes);
        this.defaultValue = defaultValue;
    }

    public CheckItemModel(String title, CharSequence imageURL, boolean defaultValue) {
        super(title, imageURL);
        this.defaultValue = defaultValue;
    }

    public CheckItemModel(String title, String subTitle, int imageRes, boolean defaultValue) {
        super(title, subTitle, imageRes);
        this.defaultValue = defaultValue;
    }

    public CheckItemModel(String title, String subTitle, CharSequence imageURL, boolean defaultValue) {
        super(title, subTitle, imageURL);
        this.defaultValue = defaultValue;
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

    public boolean isUsingSharedPreferences() {
        return useSharedPreferences;
    }

    public OnValueChange<Boolean> getOnValueChange() {
        return onValueChange;
    }

    public void setOnValueChange(OnValueChange<Boolean> onValueChange) {
        this.onValueChange = onValueChange;
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
