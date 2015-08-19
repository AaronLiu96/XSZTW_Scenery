package com.example.sdm.xsztw_scenery.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.TypedValue;

import com.example.sdm.xsztw_scenery.R;
import com.example.sdm.xsztw_scenery.ui.fragment.AwardFragment;
import com.example.sdm.xsztw_scenery.ui.fragment.SceneryFragment;
import com.example.sdm.xsztw_scenery.ui.widget.PagerSlidingTabStrip;


public class MainActivity extends FragmentActivity {

    private PagerSlidingTabStrip mPagerSlidingTabStrip;
    private ViewPager mViewPager;
    private AwardFragment awardFragment;
    private SceneryFragment sceneryFragment;
    private String[] titles = {"校长荣誉奖", "重邮美景"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), titles));
        mPagerSlidingTabStrip.setViewPager(mViewPager);
        mPagerSlidingTabStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        initTabsValue();
    }


    private void initTabsValue() {
        mPagerSlidingTabStrip.setIndicatorColor(getResources().getColor(R.color.yellow));
        mPagerSlidingTabStrip.setDividerColor(getResources().getColor(R.color.blue));
        mPagerSlidingTabStrip.setBackgroundColor(getResources().getColor(R.color.blue));
        mPagerSlidingTabStrip.setUnderlineHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                1, getResources().getDisplayMetrics()));
        mPagerSlidingTabStrip.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                2, getResources().getDisplayMetrics()));
        mPagerSlidingTabStrip.setSelectedTextColor(getResources().getColor(R.color.gray));
        mPagerSlidingTabStrip.setTextSize(50);
        mPagerSlidingTabStrip.setTextColor(getResources().getColor(R.color.white));
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {
        String[] _titles;
        public MyPagerAdapter(FragmentManager fm,String[] titles) {
            super(fm);
            _titles=titles;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return _titles[position];
        }

        @Override
        public int getCount() {
            return _titles.length;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if ( awardFragment== null) {
                        awardFragment = new AwardFragment();
                    }
                    return awardFragment;

                case 1:
                    if ( sceneryFragment== null) {
                        sceneryFragment = new SceneryFragment();
                    }
                    return sceneryFragment;


                default:
                    return null;
            }
        }
    }
}
