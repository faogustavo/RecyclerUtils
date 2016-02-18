package com.gustavofao.recyclerutils.Model;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Gustavo Fão Valvassori on 16/02/16.
 * Propósito:
 */
public class BadgeItemModel extends BaseModel {

    private String badge;
    private TextView badgeView;

    private int badgeBackgroundColor;
    private int badgeTextColor;

    public BadgeItemModel(String title) {
        super(title);
        this.badge = null;
        this.badgeView = null;
        this.badgeBackgroundColor = -1;
        this.badgeTextColor = -1;
    }

    public BadgeItemModel(String title, String subTitle) {
        super(title, subTitle);
        this.badge = null;
        this.badgeView = null;
        this.badgeBackgroundColor = -1;
        this.badgeTextColor = -1;
    }

    public BadgeItemModel(String title, int imageRes) {
        super(title, imageRes);
        this.badge = null;
        this.badgeView = null;
        this.badgeBackgroundColor = -1;
        this.badgeTextColor = -1;
    }

    public BadgeItemModel(String title, CharSequence imageURL) {
        super(title, imageURL);
        this.badge = null;
        this.badgeView = null;
        this.badgeBackgroundColor = -1;
        this.badgeTextColor = -1;
    }

    public BadgeItemModel(String title, String subTitle, int imageRes) {
        super(title, subTitle, imageRes);
        this.badge = null;
        this.badgeView = null;
        this.badgeBackgroundColor = -1;
        this.badgeTextColor = -1;
    }

    public BadgeItemModel(String title, String subTitle, CharSequence imageURL) {
        super(title, subTitle, imageURL);
        this.badge = null;
        this.badgeView = null;
        this.badgeBackgroundColor = -1;
        this.badgeTextColor = -1;
    }

    public TextView getBadgeView() {
        return badgeView;
    }

    public void setBadgeView(TextView badgeView) {
        this.badgeView = badgeView;
    }

    public String getBadge() {
        return badge;
    }

    public BadgeItemModel setBadge(String badge) {
        this.badge = badge;
        if (this.badgeView != null) {
            this.badgeView.setText(badge);
            if (this.badge != null)
                ((View) this.badgeView.getParent()).setVisibility(View.VISIBLE);
            else
                ((View) this.badgeView.getParent()).setVisibility(View.INVISIBLE);
        }
        return this;
    }

    public boolean hasBadge() {
        return badge != null;
    }

    public int getBadgeTextColor() {
        return badgeTextColor;
    }

    public int getBadgeBackgroundColor() {
        return badgeBackgroundColor;
    }

    public BadgeItemModel setBadgeColors(int badgeTextColor, int badgeBackgroundColor) {
        this.badgeTextColor = badgeTextColor;
        this.badgeBackgroundColor = badgeBackgroundColor;
        return this;
    }
}
