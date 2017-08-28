package com.yivideo.ui.fragment;

import android.view.LayoutInflater;

import com.yivideo.R;
import com.yivideo.base.BaseFragment;
import com.yivideo.presenter.index.IndexPersenter;
import com.yivideo.ui.view.index.IndexView;

import butterknife.BindView;

/**
 * Created by sunny on 2017/8/28.
 */

public class IndexFragment extends BaseFragment {

    @BindView(R.id.index_view)
    IndexView indexView;

    @Override
    protected int getLayout() {
        return R.layout.fragment_index;
    }

    @Override
    protected void initView(LayoutInflater inflater) {
       mPresenter = new IndexPersenter(indexView);
    }

    @Override
    protected void lazyFetchData() {
        ((IndexPersenter) mPresenter).getData();
    }

    @Override
    public void onResume() {
        super.onResume();
        indexView.stopBanner(false);
    }

    @Override
    public void onPause() {
        super.onPause();
        indexView.stopBanner(true);
    }
}
