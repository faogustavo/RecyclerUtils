package com.gustavofao.recyclerutils.RecyclerView.ViewHolder;

import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.gustavofao.recyclerutils.Model.FormModel;
import com.gustavofao.recyclerutils.Model.InputFieldModel;
import com.gustavofao.recyclerutils.R;
import com.gustavofao.recyclerutils.RecyclerView.Adapter.FormAdapter;
import com.gustavofao.recyclerutils.RecyclerView.Util.MyLinearLayoutManager;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Gustavo Fão Valvassori on 16/02/16.
 * Propósito:
 */
public class FormViewHolder extends BaseViewHolder {

    public static int ID_TITLE = R.id.form_title;
    public static int ID_ITEMS = R.id.form_items;
    public static int ID_SUBMIT = R.id.form_submit;

    private TextView title;
    private RecyclerView items;
    private AppCompatButton submit;

    private FormModel form;
    private FormAdapter adapter;
    private List<InputFieldModel> model;

    public FormViewHolder(View itemView) {
        super(itemView);

        this.title = (TextView) findViewById(ID_TITLE);
        this.items = (RecyclerView) findViewById(ID_ITEMS);
        this.submit = (AppCompatButton) findViewById(ID_SUBMIT);

        this.items.setLayoutManager(new MyLinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    public void setData (final FormModel form, final List<InputFieldModel> model) {
        this.form = form;
        this.model = model;

        this.adapter = new FormAdapter(getContext(), model);

        this.title.setText(Html.fromHtml(form.getTitle()));
        this.submit.setText(Html.fromHtml(form.getSubmitText()));
        this.items.setAdapter(adapter);

        this.submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (form.getOnSubmitClickListener() != null) {
                    HashMap<String, String> data = new HashMap<String, String>();
                    int count = adapter.getItemCount();
                    for (InputFieldModel m : adapter.getData()) {
                        data.put(m.getName(), m.getValue());
                    }
                    form.getOnSubmitClickListener().onSubmit(data);
                }
            }
        });
    }
}
