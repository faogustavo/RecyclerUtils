package com.gustavofao.recyclerutils.RecyclerView.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gustavofao.recyclerutils.Model.BadgeItemModel;
import com.gustavofao.recyclerutils.Model.CheckItemModel;
import com.gustavofao.recyclerutils.Model.DividerModel;
import com.gustavofao.recyclerutils.Model.FormModel;
import com.gustavofao.recyclerutils.Model.GroupModel;
import com.gustavofao.recyclerutils.Model.InputFieldModel;
import com.gustavofao.recyclerutils.Model.SwitchItemModel;
import com.gustavofao.recyclerutils.Model.TwoItemModel;
import com.gustavofao.recyclerutils.R;
import com.gustavofao.recyclerutils.RecyclerView.ViewHolder.BadgeItemViewHolder;
import com.gustavofao.recyclerutils.RecyclerView.ViewHolder.CheckItemViewHolder;
import com.gustavofao.recyclerutils.RecyclerView.ViewHolder.DividerViewHolder;
import com.gustavofao.recyclerutils.RecyclerView.ViewHolder.FormViewHolder;
import com.gustavofao.recyclerutils.RecyclerView.ViewHolder.GroupViewHolder;
import com.gustavofao.recyclerutils.RecyclerView.ViewHolder.InputViewHolder;
import com.gustavofao.recyclerutils.RecyclerView.ViewHolder.SwitchItemViewHolder;
import com.gustavofao.recyclerutils.RecyclerView.ViewHolder.TwoItemsViewHolder;

import java.util.List;

/**
 * Created by Gustavo Fão Valvassori on 13/02/16.
 * Propósito: Adapter para recyclerview com os items já adicionados
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_GROUP = 1000;

    private static final int TYPE_CHECK = 999;
    private static final int TYPE_CHECK_SUBTITLED = 998;

    private static final int TYPE_SWITCH = 997;
    private static final int TYPE_SWITCH_SUBTITLED = 996;

    private static final int TYPE_TWO_ITEM = 995;

    private static final int TYPE_BADGE = 994;
    private static final int TYPE_BADGE_SUBTITLED = 993;

    private static final int TYPE_FORM = 992;

    private static final int TYPE_DIVIDER = 990;

    private List<Object> data;
    private Context context;
    private LayoutInflater layoutInflater;

    public RecyclerAdapter(Context context, List<Object> data) {
        this.data = data;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view;

        switch (viewType) {
            case TYPE_CHECK:
                view = layoutInflater.inflate(R.layout.check_item, null);
                holder = new CheckItemViewHolder(view);
                break;

            case TYPE_CHECK_SUBTITLED:
                view = layoutInflater.inflate(R.layout.check_item_subtitled, null);
                holder = new CheckItemViewHolder(view);
                break;

            case TYPE_SWITCH:
                view = layoutInflater.inflate(R.layout.switch_item, null);
                holder = new SwitchItemViewHolder(view);
                break;

            case TYPE_SWITCH_SUBTITLED:
                view = layoutInflater.inflate(R.layout.switch_item_subtitled, null);
                holder = new SwitchItemViewHolder(view);
                break;

            case TYPE_DIVIDER:
                view = layoutInflater.inflate(R.layout.divider, null);
                holder = new DividerViewHolder(view);
                break;

            case TYPE_TWO_ITEM:
                view = layoutInflater.inflate(R.layout.two_line_item, null);
                holder = new TwoItemsViewHolder(view);
                break;

            case TYPE_GROUP:
                view = layoutInflater.inflate(R.layout.group_item, null);
                holder = new GroupViewHolder(view);
                break;

            case TYPE_BADGE:
                view = layoutInflater.inflate(R.layout.badge_item, null);
                holder = new BadgeItemViewHolder(view);
                break;

            case TYPE_BADGE_SUBTITLED:
                view = layoutInflater.inflate(R.layout.badge_item_subtitled, null);
                holder = new BadgeItemViewHolder(view);
                break;

            case TYPE_FORM:
                view = layoutInflater.inflate(R.layout.form_item, null);
                holder = new FormViewHolder(view);
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Object current = data.get(position);
        switch (getItemViewType(position)) {
            case TYPE_CHECK:
            case TYPE_CHECK_SUBTITLED:
                CheckItemViewHolder civh = (CheckItemViewHolder) holder;
                civh.setData((CheckItemModel) current);
                break;

            case TYPE_SWITCH:
            case TYPE_SWITCH_SUBTITLED:
                SwitchItemViewHolder sivh = (SwitchItemViewHolder) holder;
                sivh.setData((SwitchItemModel) current);
                break;

            case TYPE_BADGE:
            case TYPE_BADGE_SUBTITLED:
                BadgeItemViewHolder bivh = (BadgeItemViewHolder) holder;
                bivh.setData((BadgeItemModel) current);
                break;

            case TYPE_DIVIDER:
                DividerViewHolder dvh = (DividerViewHolder) holder;
                dvh.setData((DividerModel) current);
                break;

            case TYPE_TWO_ITEM:
                TwoItemsViewHolder tivh = (TwoItemsViewHolder) holder;
                tivh.setData((TwoItemModel) current);
                break;

            case TYPE_GROUP:
                GroupViewHolder gvh = (GroupViewHolder) holder;
                gvh.setData((GroupModel) current);
                break;

            case TYPE_FORM:
                FormViewHolder ivh = (FormViewHolder) holder;
                ivh.setData((FormModel) current, ((FormModel) current).getData());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        Object current = data.get(position);
        if (current instanceof SwitchItemModel) {
            if (((SwitchItemModel) current).hasSubtitle())
                return TYPE_SWITCH_SUBTITLED;
            else
                return TYPE_SWITCH;
        } else if (current instanceof CheckItemModel) {

            if (((CheckItemModel) current).hasSubtitle())
                return TYPE_CHECK_SUBTITLED;
            else
                return TYPE_CHECK;

        } else if (current instanceof BadgeItemModel) {

            if (((BadgeItemModel) current).hasSubtitle())
                return TYPE_BADGE_SUBTITLED;
            else
                return TYPE_BADGE;

        } else if (current instanceof TwoItemModel) {
            return TYPE_TWO_ITEM;
        } else if (current instanceof GroupModel) {
            return TYPE_GROUP;
        } else if (current instanceof DividerModel) {
            return TYPE_DIVIDER;
        } else if (current instanceof FormModel) {
            return TYPE_FORM;
        }

        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public List<Object> getData() {
        return data;
    }
}
