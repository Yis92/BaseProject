package com.yivideo.presenter;

import android.support.annotation.NonNull;

import com.yivideo.base.RxPresenter;
import com.yivideo.presenter.contract.MainContract;
import com.yivideo.utils.Preconditions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunny on 2017/8/22.
 */

public class MainPresenter extends RxPresenter implements MainContract.Presenter {

    MainContract.View mView;

    public MainPresenter(@NonNull MainContract.View view) {
        mView = Preconditions.checkNotNull(view);
        mView.setPresenter(this);
    }
}
