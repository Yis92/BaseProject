package com.yivideo.presenter.contract;

import com.yivideo.base.BasePresenter;
import com.yivideo.base.BaseView;

import java.util.List;

/**
 * Created by sunny on 2017/8/22.
 */

public interface MainContract {


    interface View extends BaseView {

        void showData();
    }

    interface Presenter extends BasePresenter<View> {
        void getData();
    }
}
