package com.yivideo.di.module;


import com.yivideo.app.App;
import com.yivideo.model.DataManager;
import com.yivideo.model.db.DBHelper;
import com.yivideo.model.db.RealmHelper;
import com.yivideo.model.http.HttpHelper;
import com.yivideo.model.http.RetrofitHelper1;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by codeest on 16/8/7.
 */

@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper1 retrofitHelper) {
        return retrofitHelper;
    }

    @Provides
    @Singleton
    DBHelper provideDBHelper(RealmHelper realmHelper) {
        return realmHelper;
    }


    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, DBHelper DBHelper) {
        return new DataManager(httpHelper, DBHelper);
    }
}
