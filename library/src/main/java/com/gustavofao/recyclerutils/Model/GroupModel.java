package com.gustavofao.recyclerutils.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gustavo Fão Valvassori on 14/02/16.
 * Propósito: Gerenciar os dados de um grupo
 */
public class GroupModel {

    private List<Object> data;
    private String title;

    public GroupModel(String title) {
        this.title = title;
        this.data = new ArrayList<>();
    }

    public GroupModel(List<Object> data, String title) {
        this.data = data;
        this.title = title;
    }

    public List<Object> getData() {
        return data;
    }

    public void addItem(Object data) {
        this.data.add(data);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
