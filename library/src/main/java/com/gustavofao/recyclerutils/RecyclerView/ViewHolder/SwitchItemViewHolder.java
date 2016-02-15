package com.gustavofao.recyclerutils.RecyclerView.ViewHolder;

import android.support.v7.widget.SwitchCompat;
import android.text.Html;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gustavofao.recyclerutils.Model.CheckItemModel;
import com.gustavofao.recyclerutils.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Gustavo Fão Valvassori on 13/02/16.
 * Propósito: Cria um item de recyclerview com um switch.
 */
public class SwitchItemViewHolder extends BaseViewHolder {

    public static int ID_TITLE = R.id.switchViewTitle;
    public static int ID_SUB_TITLE = R.id.switchViewSubTitle;
    public static int ID_SWITCH = R.id.switchViewSwitch;
    public static int ID_IMAGE = R.id.switchViewImage;

    private TextView title;
    private TextView subTitle;
    private SwitchCompat switchView;
    private ImageView imageView;

    private CheckItemModel model;

    private View.OnClickListener onClickListener;

    public SwitchItemViewHolder(View itemView) {
        super(itemView);

        title = (TextView) findViewById(ID_TITLE);
        subTitle = (TextView) findViewById(ID_SUB_TITLE);
        switchView = (SwitchCompat) findViewById(ID_SWITCH);
        imageView = (ImageView) findViewById(ID_IMAGE);

        getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (model == null) return;

                if (model.getOnClickListener() != null) {
                    model.getOnClickListener().onClick(v);
                } else {
                    model.setCurrentValue(!model.getCurrentValue());
                    switchView.setChecked(model.getCurrentValue());

                    if (model.isUsingSharedPreferences())
                        model.applyChanges();

                    if (model.getOnValueChange() != null)
                        model.getOnValueChange().onValueChanged(model.getCurrentValue());
                }
            }
        });

        switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (model == null) return;
                model.setCurrentValue(isChecked);

                if (model.isUsingSharedPreferences())
                    model.applyChanges();

                if (model.getOnValueChange() != null)
                    model.getOnValueChange().onValueChanged(model.getCurrentValue());
            }
        });
    }

    public void setData(CheckItemModel model) {
        this.model = model;

        this.title.setText(Html.fromHtml(model.getTitle()));
        this.switchView.setChecked(model.getCurrentValue());

        if (model.isUsingImage()) {
            if (model.isUsingImageFromURL()) {
                Picasso.with(getContext()).load(model.getImageURL()).into(this.imageView);
            } else {
                this.imageView.setImageResource(model.getImageRes());
            }
            this.imageView.setVisibility(View.VISIBLE);

            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) this.title.getLayoutParams();
            params.setMargins((int) (title.getContext().getResources().getDisplayMetrics().density * 56),
                    params.topMargin, params.rightMargin, params.bottomMargin);

            this.title.setLayoutParams(params);
        } else {
            this.imageView.setVisibility(View.GONE);
        }

        if (model.isUsingSubTitle())
            this.subTitle.setText(Html.fromHtml(model.getSubTitle()));
    }

}
