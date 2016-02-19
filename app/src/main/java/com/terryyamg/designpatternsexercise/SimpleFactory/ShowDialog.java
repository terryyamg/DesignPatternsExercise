package com.terryyamg.designpatternsexercise.SimpleFactory;

import android.app.Dialog;
import android.content.Context;

public class ShowDialog {
    public static Dialog getDialog(Context context) {
        Dialog dialog = new Dialog(context);
        dialog.setTitle("Show Me The Money");
        return dialog;
    }
}
