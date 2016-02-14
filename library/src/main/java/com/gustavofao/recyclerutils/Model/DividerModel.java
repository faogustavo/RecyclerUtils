package com.gustavofao.recyclerutils.Model;

import android.graphics.Color;

/**
 * Created by Gustavo Fão Valvassori on 13/02/16.
 * Propósito: Gerar uma divider na recyclerview
 */
public class DividerModel {

    private int color;

    public DividerModel() {
        this.color = Color.argb(36, 127, 127, 127);
    }

    public DividerModel(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
