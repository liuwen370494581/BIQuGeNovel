package com.example.biqunovel.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.biqunovel.Base.BaseFragment;
import com.example.biqunovel.EventBus.BindEventBus;
import com.example.biqunovel.Fragment.ChildFragment.DouShiFragment;
import com.example.biqunovel.Fragment.ChildFragment.EndFragment;
import com.example.biqunovel.Fragment.ChildFragment.GirlFragment;
import com.example.biqunovel.Fragment.ChildFragment.KeHuanFragment;
import com.example.biqunovel.Fragment.ChildFragment.LiShiFragment;
import com.example.biqunovel.Fragment.ChildFragment.WangYouFragment;
import com.example.biqunovel.Fragment.ChildFragment.WuXiaFragment;
import com.example.biqunovel.Fragment.ChildFragment.XuanHuanFragment;
import com.example.biqunovel.R;


/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2018/11/12 15:20
 * desc   :
 */
public class SearchFragment extends BaseFragment {

    private String[] mTabTitles = new String[]{};
    private BaseFragment[] fragments = {new XuanHuanFragment(),
            new WuXiaFragment(), new DouShiFragment(), new LiShiFragment(), new KeHuanFragment(), new WangYouFragment(), new GirlFragment(), new EndFragment()};


    @Override
    public void initData() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        initView(view);
        setListener();
        return view;
    }


    private void initView(View view) {
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        mTabTitles = getResources().getStringArray(R.array.tab_titles);
        viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager()));
        viewPager.setOffscreenPageLimit(fragments.length);
        tabLayout.setupWithViewPager(viewPager, true);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 方案二：页面选中时才去加载数据
                // BaseFragment fragment = fragments[position];
                // fragment.initData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setListener() {

    }


    private class FragmentAdapter extends FragmentPagerAdapter {
        // FragmentPagerAdapter与FragmentStatePagerAdapter区别
        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return mTabTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (mTabTitles != null) {
                return mTabTitles[position];
            }
            return super.getPageTitle(position);
        }

    }


}
