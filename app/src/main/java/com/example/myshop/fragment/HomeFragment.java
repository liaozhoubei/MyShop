package com.example.myshop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.myshop.R;
import com.example.myshop.adapter.DividerItemDecortion;
import com.example.myshop.adapter.HomeCatgoryAdapter;
import com.example.myshop.bean.HomeCategory;
import com.example.myshop.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * Create by Bei
 */
public class HomeFragment extends Fragment {
    private SliderLayout mSliderLayout;
    private PagerIndicator mIndicator;
    private RecyclerView mRecyclerView;

    private static final String TAG = "HomeFragment";
    private HomeCatgoryAdapter mHomeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mSliderLayout = (SliderLayout) view.findViewById(R.id.slider);

        mIndicator = (PagerIndicator) view.findViewById(R.id.custom_indicator);
        initSlider();
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.home_recyclerview);
        List<HomeCategory> datas = new ArrayList<>(15);
        HomeCategory category = new HomeCategory("热门活动",R.drawable.img_big_1,R.drawable.img_1_small1,R.drawable.img_1_small2);
        datas.add(category);

        category = new HomeCategory("有利可图",R.drawable.img_big_4,R.drawable.img_4_small1,R.drawable.img_4_small2);
        datas.add(category);
        category = new HomeCategory("品牌街",R.drawable.img_big_2,R.drawable.img_2_small1,R.drawable.img_2_small2);
        datas.add(category);

        category = new HomeCategory("金融街 包赚翻",R.drawable.img_big_1,R.drawable.img_3_small1,R.drawable.imag_3_small2);
        datas.add(category);

        category = new HomeCategory("超值购",R.drawable.img_big_0,R.drawable.img_0_small1,R.drawable.img_0_small2);
        datas.add(category);
        mHomeAdapter = new HomeCatgoryAdapter(datas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.addItemDecoration(new DividerItemDecortion());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mHomeAdapter);

    }

    private void initSlider() {

        // 加载图片
        TextSliderView textSliderView = new TextSliderView(this.getActivity());
        textSliderView.image("http://m.360buyimg.com/mobilecms/s300x98_jfs/t2416/102/20949846/13425/a3027ebc/55e6d1b9Ne6fd6d8f.jpg");
        textSliderView.description("新品推荐");
        textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(HomeFragment.this.getActivity(),"新品推荐",Toast.LENGTH_LONG).show();
            }
        });

        TextSliderView textSliderView2 = new TextSliderView(this.getActivity());
        textSliderView2.image("http://m.360buyimg.com/mobilecms/s300x98_jfs/t1507/64/486775407/55927/d72d78cb/558d2fbaNb3c2f349.jpg");
        textSliderView2.description("时尚男装");
        textSliderView2.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(HomeFragment.this.getActivity(),"时尚男装",Toast.LENGTH_LONG).show();
            }
        });

        TextSliderView textSliderView3 = new TextSliderView(this.getActivity());
        textSliderView3.image("http://m.360buyimg.com/mobilecms/s300x98_jfs/t1363/77/1381395719/60705/ce91ad5c/55dd271aN49efd216.jpg");
        textSliderView3.description("家电秒杀");


        textSliderView3.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {

                Toast.makeText(HomeFragment.this.getActivity(),"家电秒杀",Toast.LENGTH_LONG).show();

            }
        });

        mSliderLayout.addSlider(textSliderView);
        mSliderLayout.addSlider(textSliderView2);
        mSliderLayout.addSlider(textSliderView3);

        // 设置指示器
        mSliderLayout.setCustomIndicator(mIndicator);
        // 设置转场效果
        mSliderLayout.setCustomAnimation(new DescriptionAnimation());
        mSliderLayout.setPresetTransformer(SliderLayout.Transformer.RotateUp);
        // 切换时间
        mSliderLayout.setDuration(3000);

        mSliderLayout.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                LogUtil.d(TAG, "onPageScrolled");
            }

            @Override
            public void onPageSelected(int position) {
                LogUtil.d(TAG,"onPageSelected");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                LogUtil.d(TAG,"onPageScrollStateChanged");
            }
        });



    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mSliderLayout.stopAutoCycle();
    }
}