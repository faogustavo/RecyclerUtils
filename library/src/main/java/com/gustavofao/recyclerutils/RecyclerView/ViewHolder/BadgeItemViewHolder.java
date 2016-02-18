package com.gustavofao.recyclerutils.RecyclerView.ViewHolder;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gustavofao.recyclerutils.Model.BadgeItemModel;
import com.gustavofao.recyclerutils.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Gustavo Fão Valvassori on 16/02/16.
 * Propósito:
 */
public class BadgeItemViewHolder extends BaseViewHolder {

    public static int ID_TITLE = R.id.title;
    public static int ID_SUBTITLE = R.id.subtitle;
    public static int ID_IMAGE = R.id.image;
    public static int ID_BADGE_CONTAINER = R.id.badgeContainer;
    public static int ID_BADGE = R.id.badgeText;

    private TextView title;
    private TextView subtitle;
    private ImageView image;

    private View badgeContainer;
    private TextView badgeText;

    private BadgeItemModel model;

    public BadgeItemViewHolder(View itemView) {
        super(itemView);

        title = (TextView) findViewById(ID_TITLE);
        subtitle = (TextView) findViewById(ID_SUBTITLE);
        image = (ImageView) findViewById(ID_IMAGE);
        badgeContainer = findViewById(ID_BADGE_CONTAINER);
        badgeText = (TextView) findViewById(ID_BADGE);
    }

    public void setData (BadgeItemModel model) {
        this.model = model;
        model.setBadgeView(badgeText);

        this.title.setText(Html.fromHtml(model.getTitle()));

        if (model.hasSubtitle())
            this.subtitle.setText(Html.fromHtml(model.getSubTitle()));

        if (model.hasBadge()) {
            this.badgeText.setText(model.getBadge());

            int badgeBG = Color.GRAY;
            int badgeText = Color.WHITE;
            int roundRadius = (int) getContext().getResources().getDisplayMetrics().density * 5;

            if (model.getBadgeBackgroundColor() > -1)
                badgeBG = model.getBadgeBackgroundColor();
            if (model.getBadgeTextColor() > -1)
                badgeText = model.getBadgeTextColor();

            GradientDrawable gd = new GradientDrawable();
            gd.setColor(badgeBG);
            gd.setCornerRadius(roundRadius);
            gd.setStroke(badgeBG, badgeBG);

            this.badgeText.setTextColor(badgeText);
            if (Build.VERSION.SDK_INT < 16)
                this.badgeContainer.setBackgroundDrawable(gd);
            else
                this.badgeContainer.setBackground(gd);
        }

        if (model.hasImage()) {
            if (model.isImageFromURL()) {
                Picasso.with(getContext())
                        .load(model.getImageURL())
                        .error(R.drawable.fail_icon)
                        .into(this.image);
            } else {
                this.image.setImageResource(model.getImageRes());
            }
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
