package com.yivideo.ui.activity;

import android.os.Bundle;

import com.yivideo.R;
import com.yivideo.base.BaseActivity;
import com.yivideo.presenter.StartPresenter;
import com.yivideo.ui.view.StartView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yivideo on 2017/8/18.
 */

public class StartActivity extends BaseActivity {

    @BindView(R.id.start_view)
    StartView startView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        unbinder = ButterKnife.bind(this);
        mPresenter = new StartPresenter(startView);
    }
}
