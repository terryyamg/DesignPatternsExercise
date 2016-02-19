package com.terryyamg.designpatternsexercise.AbstractFactory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.terryyamg.designpatternsexercise.R;

public class AbstractFactory extends Fragment {
    private DialogSize ds;
    private ContentFactory cf;

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
        View view = inflater.inflate(R.layout.abstract_factory, container, false);

        final EditText etWidth = (EditText) view.findViewById(R.id.etWidth);
        final EditText etHeight = (EditText) view.findViewById(R.id.etHeight);
        final EditText etContent = (EditText) view.findViewById(R.id.etContent);
        Button btSend = (Button) view.findViewById(R.id.btSend);

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etWidth.getText().toString().length() <= 0 || etHeight.getText().toString().length() <= 0) {
                    Toast.makeText(getActivity(),"輸入不正確",Toast.LENGTH_SHORT).show();
                    return;
                }
                int width = Integer.parseInt(etWidth.getText().toString());
                int height = Integer.parseInt(etHeight.getText().toString());

                ds = new DialogSize(width, height);
                cf = new ContentFactory() {
                    @Override
                    public Content getContent() {
                        return new Content() {
                            @Override
                            public String content() {
                                String content = etContent.getText().toString();
                                return content;
                            }
                        };
                    }
                };
                ds.showDialog(cf, getActivity());
            }
        });

        return view;
    }
}
