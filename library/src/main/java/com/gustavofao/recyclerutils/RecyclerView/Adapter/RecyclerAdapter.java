package com.gustavofao.recyclerutils.RecyclerView.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gustavofao.recyclerutils.Model.CheckItemModel;
import com.gustavofao.recyclerutils.Model.DividerModel;
import com.gustavofao.recyclerutils.Model.SwitchItemModel;
import com.gustavofao.recyclerutils.Model.TwoItemModel;
import com.gustavofao.recyclerutils.R;
import com.gustavofao.recyclerutils.RecyclerView.ViewHolder.CheckItemViewHolder;
import com.gustavofao.recyclerutils.RecyclerView.ViewHolder.DividerViewHolder;
import com.gustavofao.recyclerutils.RecyclerView.ViewHolder.SwitchItemViewHolder;
import com.gustavofao.recyclerutils.RecyclerView.ViewHolder.TwoItemsViewHolder;

import java.util.List;

/**
 * Created by Gustavo Fão Valvassori on 13/02/16.
 * Propósito: Adapter para recyclerview com os items já adicionados
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_CHECK = 999;
    private static final int TYPE_CHECK_SUBTITLED = 998;

    private static final int TYPE_SWITCH = 997;
    private static final int TYPE_SWITCH_SUBTITLED = 996;

    private static final int TYPE_TWO_ITEM = 995;

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
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_CHECK:
            case TYPE_CHECK_SUBTITLED:
                CheckItemViewHolder civh = (CheckItemViewHolder) holder;
                civh.setData((CheckItemModel) data.get(position));
                break;

            case TYPE_SWITCH:
            case TYPE_SWITCH_SUBTITLED:
                SwitchItemViewHolder sivh = (SwitchItemViewHolder) holder;
                sivh.setData((SwitchItemModel) data.get(position));
                break;

            case TYPE_DIVIDER:
                DividerViewHolder dvh = (DividerViewHolder) holder;
                dvh.setData((DividerModel) data.get(position));
                break;

            case TYPE_TWO_ITEM:
                TwoItemsViewHolder tivh = (TwoItemsViewHolder) holder;
                tivh.setData((TwoItemModel) data.get(position));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (data.get(position) instanceof SwitchItemModel) {

            if (((SwitchItemModel) data.get(position)).isUsingSubTitle())
                return TYPE_SWITCH_SUBTITLED;
            else
                return TYPE_SWITCH;

        } else if (data.get(position) instanceof CheckItemModel) {

            if (((CheckItemModel) data.get(position)).isUsingSubTitle())
                return TYPE_CHECK_SUBTITLED;
            else
                return TYPE_CHECK;

        } else if (data.get(position) instanceof TwoItemModel) {
            return TYPE_TWO_ITEM;
        } else if (data.get(position) instanceof DividerModel) {
            return TYPE_DIVIDER;
        }

        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
