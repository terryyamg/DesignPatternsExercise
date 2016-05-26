package com.terryyamg.designpatternsexercise.FactoryMethod;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.terryyamg.designpatternsexercise.R;

public class FactoryMethod extends Fragment {
    private EditText etInput;
    private TextView tvType, tvLength;

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
        View view = inflater.inflate(R.layout.factory_method, container, false);

        etInput = (EditText) view.findViewById(R.id.etInput);
        Button btCheck = (Button) view.findViewById(R.id.btCheck);
        tvType = (TextView) view.findViewById(R.id.tvType);
        tvLength = (TextView) view.findViewById(R.id.tvLength);

        btCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckText ct = new Check();
                Log.i("ct","start");
                ct.input(etInput.getText().toString());
                Log.i("ct", "end");
            }
        });


        return view;
    }

    class Check extends CheckText {
        @Override
        public Text createText() {
            return new Text() {
                @Override
                public void input() {

                }

                @Override
                public void type() {
                    Log.i("type","typetypetypetype");
                    if (TYPE) {
                        tvType.setText("INT");
                    } else {
                        tvType.setText("String");
                    }
                }

                @Override
                public void length() {
                    Log.i("length","lengthlengthlengthlength");
                    tvLength.setText(Integer.toString(LENGTH));
                }
            };
        }
    }

}

