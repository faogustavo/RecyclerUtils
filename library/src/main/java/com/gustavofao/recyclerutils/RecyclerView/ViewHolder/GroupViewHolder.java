package com.gustavofao.recyclerutils.RecyclerView.ViewHolder;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.gustavofao.recyclerutils.Model.GroupModel;
import com.gustavofao.recyclerutils.R;
import com.gustavofao.recyclerutils.RecyclerView.Adapter.RecyclerAdapter;
import com.gustavofao.recyclerutils.RecyclerView.Util.MyLinearLayoutManager;

/**
 * Created by Gustavo Fão Valvassori on 14/02/16.
 * Propósito: Desativar o scroll da recyclerview interna
 */
public class GroupViewHolder extends BaseViewHolder {

    public static int ID_TITLE = R.id.group_title;
    public static int ID_ITEMS = R.id.group_items;

    private TextView title;
    private RecyclerView items;

    private GroupModel model;

    public GroupViewHolder(View itemView) {
        super(itemView);

        this.title = (TextView) findViewById(ID_TITLE);
        this.items = (RecyclerView) findViewById(ID_ITEMS);

        this.items.setLayoutManager(new MyLinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    public void setData (GroupModel model) {
        this.model = model;

        this.title.setText(Html.fromHtml(model.getTitle()));
        this.items.setAdapter(new RecyclerAdapter(getContext(), model.getData()));
    }


}
