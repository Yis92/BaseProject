package com.yivideo.ui.activity;

import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;

import com.yivideo.R;
import com.yivideo.base.BaseMvpActivity;
import com.yivideo.component.ImageLoader;
import com.yivideo.presenter.StartPresenter;
import com.yivideo.presenter.contract.StartContract;
import com.yivideo.utils.EventUtil;

import butterknife.BindView;

/**
 * Created by yivideo on 2017/8/18.
 */

public class StartActivity extends BaseMvpActivity<StartPresenter> implements StartContract.View {

    @BindView(R.id.iv_start)
    ImageView ivStart;

    @Override
    protected int getLayout() {
        return R.layout.activity_start;
    }


    @Override
    protected void initView() {
        mPresenter.getStartImg();
    }

    @Override
    public void showError(String msg) {
        EventUtil.showToast(mContext, msg);
    }


    @Override
    public void showImg(String img) {
        ImageLoader.load(mContext, img, ivStart);
    }

    @Override
    public void showFail(String msg) {

    }

    @Override
    public void jumpToMain() {
        Intent intent = new Intent(mContext, MainActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }


//    @BindView(R.id.start_view)
//    StartView startView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_start);
//        unbinder = ButterKnife.bind(this);
//        mPresenter = new StartPresenter(startView);
//    }
}
