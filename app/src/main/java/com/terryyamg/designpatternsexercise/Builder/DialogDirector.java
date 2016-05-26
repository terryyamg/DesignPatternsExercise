package com.terryyamg.designpatternsexercise.Builder;

import android.util.Log;

// 架構
interface DialogSetting {
    void setSize(int w,int h);
    MyDialog getMyDialog();
}

// 材質
interface MyDialog {
    void show();
}

class DialogDirector {
    private int[] myDialog;
    private DialogSetting ds;

    DialogDirector(int[] myDialog, DialogSetting ds){
        this.myDialog = myDialog;
        this.ds = ds;
    }

    MyDialog build(){
        int w = myDialog[0]; //寬
        int h = myDialog[1]; //高
        Log.i("wwwww",w+"");
        Log.i("hhhhh",h+"");
        ds.setSize(w,h);

        return ds.getMyDialog();
    }

}
