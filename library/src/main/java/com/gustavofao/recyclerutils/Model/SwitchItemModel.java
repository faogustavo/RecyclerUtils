package com.gustavofao.recyclerutils.Model;

/**
 * Created by Gustavo Fão Valvassori on 13/02/16.
 * Propósito:
 */
public class SwitchItemModel extends CheckItemModel {
    public SwitchItemModel(String title) {
        super(title);
    }

    public SwitchItemModel(String title, int imageRes) {
        super(title, imageRes);
    }

    public SwitchItemModel(String title, String subtitle) {
        super(title, subtitle);
    }

    public SwitchItemModel(String title, String subtitle, int imageRes) {
        super(title, subtitle, imageRes);
    }
}
