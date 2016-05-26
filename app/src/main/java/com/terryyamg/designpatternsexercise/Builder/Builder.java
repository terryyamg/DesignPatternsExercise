package com.terryyamg.designpatternsexercise.Builder;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.terryyamg.designpatternsexercise.R;

public class Builder extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return initView(inflater, container);
    }

    private View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.builder, container, false);

        Button btSquare = (Button) view.findViewById(R.id.btSquare);
        Button btRectangle = (Button) view.findViewById(R.id.btRectangle);

        btSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] wh = {100,100};
                show(wh);
            }
        });

        btRectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] wh = {100,200};
                show(wh);
            }
        });

        return view;
    }

    class ShowDialog implements DialogSetting {
        private Context context;
        private Dialog dialog;

        ShowDialog(Context context) {
            this.context = context;
        }

        @Override
        public void setSize(int w, int h) {
            dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.abstract_factory_dialog);
            WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
            params.width = w; //設定寬
            params.height = h ; //設定高
            dialog.getWindow().setAttributes(params);
        }

        @Override
        public MyDialog getMyDialog() {
            return new MyDialog() {
                @Override
                public void show() {
                    dialog.show();
                }
            };
        }
    }

    private void show(int[] wh){
        DialogDirector dd = new DialogDirector(wh, new ShowDialog(getActivity()));
        dd.build().show();
    }
}
