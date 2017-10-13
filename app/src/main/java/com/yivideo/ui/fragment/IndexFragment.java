package com.yivideo.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.jude.rollviewpager.hintview.IconHintView;
import com.yivideo.R;
import com.yivideo.base.BaseMvpFragment;
import com.yivideo.presenter.contract.index.IndexContract;
import com.yivideo.presenter.index.IndexPersenter;
import com.yivideo.ui.activity.MainActivity;
import com.yivideo.ui.adapter.IndexPagerAdapter;
import com.yivideo.ui.adapter.MainRecycleAdapter;
import com.yivideo.utils.ScreenUtil;
import com.yivideo.widget.RollPagerView;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunny on 2017/8/28.
 */

public class IndexFragment extends BaseMvpFragment<IndexPersenter> implements IndexContract.View, SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.recycler_view)
    EasyRecyclerView recyclerView;

    RollPagerView rollPagerView;
    View headerView;
    MainRecycleAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_index;
    }

    @Override
    protected void initView(LayoutInflater inflater) {

        //注册EventBus
        EventBus.getDefault().register(this);


        headerView = LayoutInflater.from(mContext).inflate(R.layout.recommend_header, null);
        rollPagerView = ButterKnife.findById(headerView, R.id.roll_pager_view);
        rollPagerView.setPlayDelay(2000);

        recyclerView.setAdapterWithProgress(adapter = new MainRecycleAdapter(getContext()));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setErrorView(R.layout.view_error);

        //item间隔
        SpaceDecoration itemDecoration = new SpaceDecoration(ScreenUtil.dip2px(getContext(), 8));
        itemDecoration.setPaddingEdgeSide(true);
        itemDecoration.setPaddingStart(true);
        itemDecoration.setPaddingHeaderFooter(false);
        recyclerView.addItemDecoration(itemDecoration);

//        SpaceDecoration itemDecoration = new SpaceDecoration(ScreenUtil.dip2px(getContext(), 8));//参数是距离宽度
//        itemDecoration.setPaddingEdgeSide(true);//是否为左右2边添加padding.默认true.
//        itemDecoration.setPaddingStart(true);//是否在给第一行的item添加上padding(不包含header).默认true.
//        itemDecoration.setPaddingHeaderFooter(false);//是否对Header于Footer有效,默认false.
//        recyclerView.addItemDecoration(itemDecoration);

        recyclerView.setRefreshListener(this);
    }

    @Override
    protected void initEvent() {
        mPresenter.getData();
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public boolean isDesActivity() {
        return false;
    }

    @Override
    public void showContent(final List<String> img, List<String> img2) {
        if (img != null) {
            adapter.clear();
            adapter.addAll(img2);
            if (adapter.getHeaderCount() == 0) {
                adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
                    @Override
                    public View onCreateView(ViewGroup parent) {
                        rollPagerView.setHintView(new IconHintView(getContext(), R.mipmap.ic_page_indicator_focused, R.mipmap.ic_page_indicator, ScreenUtil.dip2px(getContext(), 10)));
                        rollPagerView.setHintPadding(0, 0, 0, ScreenUtil.dip2px(getContext(), 8));
                        rollPagerView.setAdapter(new IndexPagerAdapter(getContext(), img));
                        return headerView;
                    }

                    @Override
                    public void onBindView(View headerView) {

                    }
                });
            }
        }
    }

    @Override
    public void onRefresh() {
        mPresenter.getData();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Subscriber(tag = MainActivity.Banner_Stop)
    public void stopBanner(boolean stop) {
        if (stop) {
            rollPagerView.pause();
        } else {
            rollPagerView.resume();
        }
    }


//    @BindView(R.id.index_view)
//    IndexView indexView;
//
//    @Override
//    protected int getLayout() {
//        return R.layout.fragment_index;
//    }
//
//    @Override
//    protected void initView(LayoutInflater inflater) {
//       mPresenter = new IndexPersenter(indexView);
//    }
//
//    @Override
//    protected void lazyFetchData() {
//        ((IndexPersenter) mPresenter).getData();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        indexView.stopBanner(false);
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        indexView.stopBanner(true);
//    }
}
