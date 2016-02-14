package com.gustavofao.recyclerutils.RecyclerView.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gustavofao.recyclerutils.Model.TwoItemModel;
import com.gustavofao.recyclerutils.R;

/**
 * Created by Gustavo Fão Valvassori on 13/02/16.
 * Propósito:
 */
public class TwoItemsViewHolder extends BaseViewHolder {

    public static int ID_TITLE = R.id.title;
    public static int ID_SUBTITLE = R.id.subtitle;
    public static int ID_IMAGE = R.id.image;

    private TextView title;
    private TextView subtitle;
    private ImageView image;

    private TwoItemModel model;

    public TwoItemsViewHolder(View itemView) {
        super(itemView);

        title = (TextView) findViewById(ID_TITLE);
        subtitle = (TextView) findViewById(ID_SUBTITLE);
        image = (ImageView) findViewById(ID_IMAGE);
    }

    public void setData (TwoItemModel model) {
        this.model = model;

        this.title.setText(model.getTitle());
        this.subtitle.setText(model.getSubTitle());

        if (model.isUsingImage()) {
            this.image.setImageResource(model.getImageRes());
            this.image.setVisibility(View.VISIBLE);

            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) this.title.getLayoutParams();
            params.setMargins((int) (title.getContext().getResources().getDisplayMetrics().density * 56),
                    params.topMargin, params.rightMargin, params.bottomMargin);
            this.title.setLayoutParams(params);
        } else {
            this.image.setVisibility(View.GONE);
        }

        getView().setOnClickListener(model.getOnClickListener());
    }

}
