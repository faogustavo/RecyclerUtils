package com.gustavofao.recyclerutils.Model;

import com.gustavofao.recyclerutils.Interfaces.OnSubmitClick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gustavo Fão Valvassori on 16/02/16.
 * Propósito:
 */
public class FormModel {

    private String title;
    private String submitText;
    private List<InputFieldModel> data;
    private OnSubmitClick onSubmitClick;

    public FormModel(String title, String submitText) {
        this.title = title;
        this.submitText = submitText;
        this.data = new ArrayList<>();
    }

    public FormModel(String title, String submitText, List<InputFieldModel> data) {
        this.title = title;
        this.submitText = submitText;
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubmitText() {
        return submitText;
    }

    public void setSubmitText(String submitText) {
        this.submitText = submitText;
    }

    public List<InputFieldModel> getData() {
        return data;
    }

    public void addData(InputFieldModel data) {
        this.data.add(data);
    }

    public OnSubmitClick getOnSubmitClickListener() {
        return onSubmitClick;
    }

    public void setOnSubmitClickListener(OnSubmitClick onSubmitClick) {
        this.onSubmitClick = onSubmitClick;
    }
}
