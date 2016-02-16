package com.gustavofao.recyclerutils.Model;

import android.view.View;

/**
 * Created by Gustavo Fão Valvassori on 13/02/16.
 * Propósito:
 */
public class TwoItemModel extends BaseModel{

    public TwoItemModel(String title, String subTitle) {
        super(title, subTitle);
    }

    public TwoItemModel(String title, String subTitle, int imageRes) {
        super(title, subTitle, imageRes);
    }

    public TwoItemModel(String title, String subTitle, CharSequence imageURL) {
        super(title, subTitle, imageURL);
    }
}
