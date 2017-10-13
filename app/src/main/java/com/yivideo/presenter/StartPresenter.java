package com.yivideo.presenter;

import com.yivideo.base.RxPresenter;
import com.yivideo.presenter.contract.StartContract;
import com.yivideo.utils.RxUtil;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by sunny on 2017/8/22.
 */

public class StartPresenter extends RxPresenter<StartContract.View> implements StartContract.Presenter {

    private static final int COUNT_DOWN_TIME = 2200;

    @Inject
    public StartPresenter() {
    }

    @Override
    public void getStartImg() {
        getImg();
        startToMainActivity();
    }

    public void getImg() {

        mView.showImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507902283602&di=f78eded4894dc83e7d81d4e7005b2c20&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01b37f577cdf3e0000018c1b619291.jpg");

        //以下是正确的接口请求方式，出于公司接口隐私，去掉了接口地址
//        Subscription rxSubscription = RetrofitHelper.getVideoApi().getStartImg()
//                .compose(RxUtil.<VideoHttpResponse<StartResp>>rxSchedulerHelper())
//                .compose(RxUtil.<StartResp>handleResult())
//                .subscribe(new Action1<StartResp>() {
//                    @Override
//                    public void call(final StartResp res) {
//                        if (res != null) {
//                            if (mView.isActive()) {
//                                mView.showImg(res.getImg());
//                            }
//                        }
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
////                        mView.showFail(StringUtils.getErrorMsg(throwable.getMessage()));
////                        mView.refreshFaild(StringUtils.getErrorMsg(throwable.getMessage()));
//                    }
//                });
//        addSubscribe(rxSubscription);
    }

    /**
     * n秒后自动跳转到主页面
     */
    private void startToMainActivity() {
        Subscription rxSubscription = Observable.timer(COUNT_DOWN_TIME, TimeUnit.MILLISECONDS)
                .compose(RxUtil.<Long>rxSchedulerHelper())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        mView.jumpToMain();
                    }
                });
        addSubscribe(rxSubscription);
    }
}

