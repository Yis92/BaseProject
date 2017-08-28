package com.yivideo.model.db;


import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Description: RealmHelper
 * Creator: yxc
 * date: 2016/9/21 17:46
 */

public class RealmHelper implements DBHelper {

    public static final String DB_NAME = "ghost.realm";
    private Realm mRealm;
    private static RealmHelper instance;


    public static RealmHelper getInstance() {
        if (instance == null) {
            synchronized (RealmHelper.class) {
                if (instance == null)
                    instance = new RealmHelper();
            }
        }
        return instance;
    }

    @Inject
    public RealmHelper() {
        mRealm = Realm.getInstance(new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name(DB_NAME)
                .build());
    }

    public Realm getRealm() {
        if (mRealm == null || mRealm.isClosed())
            mRealm = Realm.getDefaultInstance();
        return mRealm;
    }
    //--------------------------------------------------收藏相关----------------------------------------------------


}
