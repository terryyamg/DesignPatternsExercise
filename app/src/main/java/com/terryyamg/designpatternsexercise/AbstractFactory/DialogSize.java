package com.terryyamg.designpatternsexercise.AbstractFactory;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.terryyamg.designpatternsexercise.R;

interface ContentFactory {
    Content getContent();
}

interface Content {
    String content();
}

public class DialogSize {
    private int width;
    private int height;

    DialogSize(int width, int height){
        this.width = width;
        this.height = height;
    }

    void showDialog(ContentFactory cf,Context context){
        Content ct = cf.getContent();
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.setContentView(R.layout.abstract_factory_dialog);
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.width = width; //設定寬
        params.height = height ; //設定高
        dialog.getWindow().setAttributes(params);

        Log.i("width", width + "");
        Log.i("height", height + "");
        TextView tvContent = (TextView) dialog.findViewById(R.id.tvContent);
        tvContent.setText(ct.content()); //內容
        dialog.show();
    }
}
