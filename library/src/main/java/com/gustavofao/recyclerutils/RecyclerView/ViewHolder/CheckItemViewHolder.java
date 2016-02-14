package com.gustavofao.recyclerutils.RecyclerView.ViewHolder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gustavofao.recyclerutils.Model.CheckItemModel;
import com.gustavofao.recyclerutils.R;

/**
 * Created by Gustavo Fão Valvassori on 13/02/16.
 * Propósito: Criar um item para recyclerview com um checkbox.
 */
public class CheckItemViewHolder extends BaseViewHolder {

    public static int ID_TITLE = R.id.checkViewTitle;
    public static int ID_SUBTITLE = R.id.checkViewSubTitle;
    public static int ID_CHECK = R.id.checkViewCheck;
    public static int ID_IMAGE = R.id.checkViewImage;

    private TextView title;
    private TextView subTitle;
    private CheckBox check;
    private ImageView imageView;

    private CheckItemModel model;

    public CheckItemViewHolder(View itemView) {
        super(itemView);

        title = (TextView) findViewById(ID_TITLE);
        subTitle = (TextView) findViewById(ID_SUBTITLE);
        check = (CheckBox) findViewById(ID_CHECK);
        imageView = (ImageView) findViewById(ID_IMAGE);

        getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (model == null) return;

                if (model.getOnClickListener() != null) {
                    model.getOnClickListener().onClick(v);
                } else {
                    model.setCurrentValue(!model.getCurrentValue());
                    check.setChecked(model.getCurrentValue());

                    if (model.isUsingSharedPreferences())
                        model.applyChanges();

                    if (model.getOnCheckValueChange() != null)
                        model.getOnCheckValueChange().onCheckValueChanged(model.getCurrentValue());
                }
            }
        });

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (model == null) return;
                model.setCurrentValue(isChecked);

                if (model.isUsingSharedPreferences())
                    model.applyChanges();
            }
        });
    }

    public void setData(CheckItemModel model) {
        this.model = model;
        this.title.setText(model.getTitle());
        this.check.setChecked(model.getCurrentValue());

        if (model.isUsingImage()) {
            this.imageView.setImageResource(model.getImageRes());
            this.imageView.setVisibility(View.VISIBLE);

            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) this.title.getLayoutParams();
            params.setMargins((int) (title.getContext().getResources().getDisplayMetrics().density * 56),
                    params.topMargin, params.rightMargin, params.bottomMargin);
            this.title.setLayoutParams(params);
        }

        if (model.isUsingSubTitle())
            this.subTitle.setText(model.getSubTitle());
    }
}
