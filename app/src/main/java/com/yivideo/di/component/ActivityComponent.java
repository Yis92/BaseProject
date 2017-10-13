package com.yivideo.di.component;

import android.app.Activity;


import com.yivideo.di.module.ActivityModule;
import com.yivideo.di.scope.ActivityScope;
import com.yivideo.ui.activity.MainActivity;
import com.yivideo.ui.activity.StartActivity;

import dagger.Component;

/**
 * Description:
 * Creator: yxc
 * date: $date $time
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {
    Activity getActivity();

    //    void inject(VideoInfoActivity videoInfoActivity);
    void inject(MainActivity mainActivity);

    void inject(StartActivity startActivity);

}
