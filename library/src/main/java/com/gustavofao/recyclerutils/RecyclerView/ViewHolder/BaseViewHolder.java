package com.gustavofao.recyclerutils.RecyclerView.ViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Gustavo Fão Valvassori on 13/02/16.
 * Propósito: ViewHolder com métodos findViewById e getView
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    private View view;

    public BaseViewHolder(View itemView) {
        super(itemView);
        this.view = itemView;
    }

    public View findViewById (int id) {
        return view.findViewById(id);
    }

    public View getView () {
        return view;
    }

    public Context getContext () {
        return view.getContext();
    }
}
