package com.gustavofao.recyclerutils.RecyclerView.ViewHolder;

import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gustavofao.recyclerutils.Model.InputFieldModel;
import com.gustavofao.recyclerutils.R;
import com.gustavofao.recyclerutils.RecyclerView.Adapter.RecyclerAdapter;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Gustavo Fão Valvassori on 16/02/16.
 * Propósito:
 */
public class InputViewHolder extends BaseViewHolder {

    public static int ID_HOLDER = R.id.input_wraper;
    public static int ID_INPUT = R.id.input;

    private TextInputLayout inputHolder;
    private EditText input;

    private InputFieldModel model;

    public InputViewHolder(View itemView) {
        super(itemView);

        inputHolder = (TextInputLayout) findViewById(ID_HOLDER);
        input = (EditText) findViewById(ID_INPUT);

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (model != null)
                    model.setValue(s.toString());
            }
        });
    }

    public void setData(final InputFieldModel model) {
        this.model = model;

        inputHolder.setVisibility(View.VISIBLE);
        inputHolder.setHint(model.getHint());
        input.setText(model.getValue());

        if (model.getMaxSize() > 0) {
            InputFilter[] filterArray = new InputFilter[1];
            filterArray[0] = new InputFilter.LengthFilter(model.getMaxSize());
            input.setFilters(filterArray);
        }

        switch (model.getInputType()) {
            case TEXT:
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                break;

            case NUMBER:
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;

            case EMAIL:
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                break;

            case PASSWORD:
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                break;

            case PHONE:
                input.setInputType(InputType.TYPE_CLASS_PHONE);
                break;
        }

    }
    
    public String getValue () {
        return input.getText().toString();
    }

    public String getName() {
        return model.getName();
    }
}
