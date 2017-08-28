package com.yivideo.model.http;

import com.yivideo.model.http.api.GankApis;
import com.yivideo.model.http.api.VideoApis;

import javax.inject.Inject;

/**
 * Created by codeest on 2016/8/3.
 */
public class RetrofitHelper1 implements HttpHelper {

    private VideoApis mVideoApis;
    private GankApis mGankApis;
    
    @Inject
    public RetrofitHelper1(VideoApis videoApis, GankApis gankApis) {
        this.mVideoApis = videoApis;
        this.mGankApis = gankApis;
    }


}
