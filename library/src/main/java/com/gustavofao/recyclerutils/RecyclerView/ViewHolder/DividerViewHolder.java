package com.gustavofao.recyclerutils.RecyclerView.ViewHolder;

import android.view.View;
import android.widget.RelativeLayout;

import com.gustavofao.recyclerutils.Model.DividerModel;
import com.gustavofao.recyclerutils.R;

/**
 * Created by Gustavo Fão Valvassori on 13/02/16.
 * Propósito:
 */
public class DividerViewHolder extends BaseViewHolder {

    public static int ID_DIVIDER = R.id.dividerColor;

    private RelativeLayout dividerColor;
    private DividerModel model;

    public DividerViewHolder(View itemView) {
        super(itemView);
        dividerColor = (RelativeLayout) findViewById(ID_DIVIDER);
    }

    public void setData (DividerModel model) {
        this.model = model;
        dividerColor.setBackgroundColor(model.getColor());
    }

}
