// (c)2016 Flipboard Inc, All Rights Reserved.

package com.yivideo.model.http.api;


import com.yivideo.model.bean.StartResp;
import com.yivideo.model.http.response.VideoHttpResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Description: VideoApis
 * Creator: yxc
 * date: 2016/9/8 14:05
 */

public interface VideoApis {
    String HOST = "http://www.baidu.com/";

    /**
     * 首页
     *
     * @return
     */
    @GET("去掉了接口地址")
    Observable<VideoHttpResponse<StartResp>> getStartImg();

}
