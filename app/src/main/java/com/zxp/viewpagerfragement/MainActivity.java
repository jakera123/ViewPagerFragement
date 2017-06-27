package com.zxp.viewpagerfragement;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.zxp.viewpagerfragement.Adapter.FragAdapter;
import com.zxp.viewpagerfragement.Fragment.Fragment1;
import com.zxp.viewpagerfragement.Fragment.Fragment2;
import com.zxp.viewpagerfragement.Fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FragmentPagerAdapter adapter;
    private ViewPager viewPager;
    private MyHandler myHandler;
    private ImageView iv_viewpager;
    private int[] images={R.drawable.one,R.drawable.two,R.drawable.three};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myHandler=new MyHandler();

        List<Fragment> fragments=new ArrayList<Fragment>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        adapter=new FragAdapter(getSupportFragmentManager(),fragments);

        viewPager=(ViewPager)findViewById(R.id.vp_myviewpager);
        viewPager.setAdapter(adapter);

        iv_viewpager=(ImageView) findViewById(R.id.iv_viewpager);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message msg=new Message();
                    msg.arg1=1;
                    MainActivity.this.myHandler.sendMessage(msg);

                }
            }
        }).start();


    }

    class MyHandler extends Handler{


        public MyHandler(){}
        public MyHandler(Looper L){
            super(L);
        }

        @Override
        public void handleMessage(Message msg) {
            if(msg.arg1==1) {
                int count = adapter.getCount();
                if (count > 1) { // 多于1个，才循环
                    int index = viewPager.getCurrentItem();
                    index = (index + 1) % count;
                    viewPager.setCurrentItem(index, true);
                    iv_viewpager.setImageResource(images[index]);


                }
            }
        }
    }


}
