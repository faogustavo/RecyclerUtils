package com.gustavofao.recyclerutils.Model;

import android.widget.EditText;

import com.gustavofao.recyclerutils.Interfaces.OnValueChange;
import com.gustavofao.recyclerutils.RecyclerView.ViewHolder.InputViewHolder;

import java.util.HashMap;

/**
 * Created by Gustavo Fão Valvassori on 16/02/16.
 * Propósito:
 */
public class InputFieldModel {

    public enum InputType {
        TEXT, NUMBER, EMAIL, PASSWORD, PHONE
    }

    private int maxSize;

    private String hint;
    private String name;
    private String defaultValue;
    private String value;

    private InputType inputType;

    private OnValueChange<HashMap<String, String>> onSubmitClick;

    public InputFieldModel(String hint, String name, InputType inputType) {
        this.hint = hint;
        this.name = name;
        this.inputType = inputType;
        this.value = "";
    }

    public InputFieldModel(String hint, String name, InputType inputType, int maxSize) {
        this.hint = hint;
        this.name = name;
        this.maxSize = maxSize;
        this.inputType = inputType;
        this.value = "";
    }

    public InputFieldModel(String hint, String name, String defaultValue, InputType inputType) {
        this.hint = hint;
        this.name = name;
        this.inputType = inputType;
        this.defaultValue = defaultValue;
        this.value = defaultValue;
    }

    public InputFieldModel(String hint, String name, String defaultValue, int maxSize, InputType inputType) {
        this.hint = hint;
        this.name = name;
        this.maxSize = maxSize;
        this.inputType = inputType;
        this.defaultValue = defaultValue;
        this.value = defaultValue;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public InputType getInputType() {
        return inputType;
    }

    public void setInputType(InputType inputType) {
        this.inputType = inputType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public OnValueChange<HashMap<String, String>> getOnSubmitClick() {
        return onSubmitClick;
    }

    public InputFieldModel setOnSubmitClick(OnValueChange<HashMap<String, String>> onSubmitClick) {
        this.onSubmitClick = onSubmitClick;
        return this;
    }
}
