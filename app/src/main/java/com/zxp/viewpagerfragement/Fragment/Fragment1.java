package com.zxp.viewpagerfragement.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.zxp.viewpagerfragement.R;

/**
 * Created by xiaoxin on 2017/6/27.
 */

public class Fragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout1,container,false);

        Button btn=(Button)view.findViewById(R.id.btn_fragment1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"点击了第一个Frgament的BTN",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
