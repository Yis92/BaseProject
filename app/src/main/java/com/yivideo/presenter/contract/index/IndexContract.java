package com.yivideo.presenter.contract.index;

import com.yivideo.base.BasePresenter;
import com.yivideo.base.BaseView;

import java.util.List;

/**
 * Created by sunny on 2017/8/28.
 */

public interface IndexContract {

    //定义界面交互的接口
    interface View extends BaseView {
        //activity是否被销毁
        boolean isDesActivity();

        /**
         * 显示首页展示内容
         *
         * @param img  首页viewpager轮播图的图片
         * @param img2 RecycleView 图片
         */
        void showContent(List<String> img, List<String> img2);
    }

    //定义需要操作数据的接口，增删改查等....
    interface Persenter extends BasePresenter<View> {
        void getData();
    }
}
