package com.yivideo.presenter.contract;

import com.yivideo.base.BasePresenter;
import com.yivideo.base.BaseView;


/**
 * Created by sunny on 2017/8/22.
 */

public interface StartContract {

    interface View extends BaseView<Presenter> {
        boolean isActive();

        void showImg(String img);

        void showFail(String msg);

        void jumpToMain();
    }

    interface Presenter extends BasePresenter {
        void getStartImg();
    }
}
