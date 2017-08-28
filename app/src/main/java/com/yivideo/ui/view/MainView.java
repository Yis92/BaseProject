package com.yivideo.ui.view;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.jude.rollviewpager.hintview.IconHintView;
import com.yivideo.R;
import com.yivideo.base.RootView;
import com.yivideo.presenter.contract.MainContract;
import com.yivideo.ui.activity.MainActivity;
import com.yivideo.ui.adapter.IndexPagerAdapter;
import com.yivideo.ui.adapter.MainPagerAdapter;
import com.yivideo.ui.adapter.MainRecycleAdapter;
import com.yivideo.ui.fragment.HotFragment;
import com.yivideo.ui.fragment.IndexFragment;
import com.yivideo.ui.fragment.UserFragment;
import com.yivideo.ui.fragment.ZhiboFragment;
import com.yivideo.utils.Preconditions;
import com.yivideo.utils.ScreenUtil;
import com.yivideo.widget.RollPagerView;
import com.yivideo.widget.UnScrollViewPager;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yivideo on 2017/8/22.
 */

public class MainView extends RootView<MainContract.Presenter> implements MainContract.View {

    @BindView(R.id.view_pager)
    UnScrollViewPager viewPager;
    private MainPagerAdapter mainPagerAdapter;

    @BindView(R.id.rg_tab)
    RadioGroup rgTab;
    @BindView(R.id.rb_index)
    RadioButton rbIndex;
    @BindView(R.id.rb_hot)
    RadioButton rbHot;
    @BindView(R.id.rb_zhibo)
    RadioButton rbZhibo;
    @BindView(R.id.rb_user)
    RadioButton rbUser;

    public MainView(Context context) {
        super(context);
    }

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.activity_main_view, this);
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
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = Preconditions.checkNotNull(presenter);
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

}
