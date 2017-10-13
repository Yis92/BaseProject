package com.yivideo.ui.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yivideo.R;
import com.yivideo.app.App;
import com.yivideo.base.BaseMvpActivity;
import com.yivideo.presenter.MainPresenter;
import com.yivideo.presenter.contract.MainContract;
import com.yivideo.ui.adapter.MainPagerAdapter;
import com.yivideo.ui.fragment.HotFragment;
import com.yivideo.ui.fragment.IndexFragment;
import com.yivideo.ui.fragment.UserFragment;
import com.yivideo.ui.fragment.ZhiboFragment;
import com.yivideo.utils.EventUtil;
import com.yivideo.widget.UnScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {

    private Long firstTime = 0L;
    public final static String Banner_Stop = "Banner_Stop";
    public static final String Set_Theme_Color = "Set_Theme_Color";

    @BindView(R.id.view_pager)
    UnScrollViewPager viewPager;
    private MainPagerAdapter mainPagerAdapter;

    @BindView(R.id.rg_tab)
    RadioGroup rgTab;


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        List<Fragment> fragments = new ArrayList<>();
        Fragment indexFragment = new IndexFragment();
        Fragment hotFragment = new HotFragment();
        Fragment zhiboFragment = new ZhiboFragment();
        Fragment userFragment = new UserFragment();
        fragments.add(indexFragment);
        fragments.add(hotFragment);
        fragments.add(zhiboFragment);
        fragments.add(userFragment);
        mainPagerAdapter = new MainPagerAdapter(((MainActivity) mContext).getSupportFragmentManager(), fragments);
        viewPager.setAdapter(mainPagerAdapter);
        viewPager.setOffscreenPageLimit(fragments.size());
    }

    @Override
    protected void initEvent() {
        rgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.rb_index:
                        viewPager.setCurrentItem(0, false);
                        break;
                    case R.id.rb_hot:
                        viewPager.setCurrentItem(1, false);
                        break;
                    case R.id.rb_zhibo:
                        viewPager.setCurrentItem(2, false);
                        break;
                    case R.id.rb_user:
                        viewPager.setCurrentItem(3, false);
                        break;
                }
            }
        });
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showData() {

    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 1500) {
            EventUtil.showToast(this, "再按一次退出");
            firstTime = secondTime;
        } else {
            App.getInstance().exitApp();
        }
    }

}
