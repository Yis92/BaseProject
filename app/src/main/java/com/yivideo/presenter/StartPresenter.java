package com.yivideo.presenter;

import android.support.annotation.NonNull;

import com.yivideo.base.RxPresenter;
import com.yivideo.model.bean.StartResp;
import com.yivideo.model.http.response.VideoHttpResponse;
import com.yivideo.model.net.RetrofitHelper;
import com.yivideo.presenter.contract.StartContract;
import com.yivideo.utils.Preconditions;
import com.yivideo.utils.RxUtil;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by sunny on 2017/8/22.
 */

public class StartPresenter extends RxPresenter implements StartContract.Presenter {

    private static final int COUNT_DOWN_TIME = 2200;

    StartContract.View mView;

    public StartPresenter(@NonNull StartContract.View oneView) {
        mView = Preconditions.checkNotNull(oneView);
        mView.setPresenter(this);
        getStartImg();
    }

    @Override
    public void getStartImg() {
        getImg();
        startToMainActivity();
    }

    public void getImg() {

        mView.showImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503921989167&di=1eccf19769ad5b81e8e974aec79fce0d&imgtype=0&src=http%3A%2F%2Fwww.7app.net%2Fwp-content%2Fuploads%2F2015%2F03%2Fmeet-you-meiyou.jpg");

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

