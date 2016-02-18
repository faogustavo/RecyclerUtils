package com.gustavofao.recyclerutils.RecyclerView.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gustavofao.recyclerutils.Model.InputFieldModel;
import com.gustavofao.recyclerutils.R;
import com.gustavofao.recyclerutils.RecyclerView.ViewHolder.InputViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gustavo Fão Valvassori on 16/02/16.
 * Propósito:
 */
public class FormAdapter extends RecyclerView.Adapter<InputViewHolder> {

    private Context context;
    private List<InputFieldModel> data;
    private LayoutInflater layoutInflater;

    public FormAdapter(Context context, List<InputFieldModel> data) {
        this.context = context;
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public InputViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new InputViewHolder(layoutInflater.inflate(R.layout.input_item, null));
    }

    @Override
        public void onBindViewHolder(InputViewHolder holder, int position) {
        holder.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public List<InputFieldModel> getData() {
        return data;
    }
}
