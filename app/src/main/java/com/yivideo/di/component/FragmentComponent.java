package com.yivideo.di.component;

import android.app.Activity;


import com.yivideo.di.module.FragmentModule;
import com.yivideo.di.scope.FragmentScope;
import com.yivideo.ui.fragment.IndexFragment;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(IndexFragment indexFragment);

}
