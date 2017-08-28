package com.yivideo.di.component;


import com.yivideo.app.App;
import com.yivideo.di.module.AppModule;
import com.yivideo.di.module.HttpModule;
import com.yivideo.model.DataManager;
import com.yivideo.model.db.RealmHelper;
import com.yivideo.model.http.RetrofitHelper1;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context

    DataManager getDataManager(); //数据中心

    RetrofitHelper1 retrofitHelper();  //提供http的帮助类

    RealmHelper realmHelper();    //提供数据库帮助类

}
