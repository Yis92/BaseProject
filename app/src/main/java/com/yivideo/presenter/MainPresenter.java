package com.yivideo.presenter;

import com.yivideo.base.RxPresenter;
import com.yivideo.presenter.contract.MainContract;

import javax.inject.Inject;

/**
 * Created by sunny on 2017/8/22.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {

    @Inject
    public MainPresenter() {

    }

    @Override
    public void getData() {

    }
}
