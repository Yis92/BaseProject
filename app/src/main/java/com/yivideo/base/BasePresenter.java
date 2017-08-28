package com.yivideo.base;

/**
 * Created by sunny on 2017/8/18.
 */
public interface BasePresenter<T> {
    void attachView(T view);

    void detachView();
}
