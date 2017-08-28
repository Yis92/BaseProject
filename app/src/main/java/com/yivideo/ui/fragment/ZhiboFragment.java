package com.yivideo.ui.fragment;

import android.widget.TextView;

import com.yivideo.R;
import com.yivideo.base.BaseFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;

/**
 * Created by sunny on 2017/8/28.
 */

public class ZhiboFragment extends BaseFragment {

    @BindView(R.id.tv_zhibo)
    TextView tvZhibo;

    @Override
    protected int getLayout() {
        return R.layout.fragment_zhibo;
    }
    @Override
    protected void lazyFetchData() {
        //测试懒加载
        tvZhibo.setText("直播& 当前时间是："+transferLongToDate("MM/dd/yyyy HH:mm:ss", System.currentTimeMillis()));
    }


    public String transferLongToDate(String dateFormat, Long millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = new Date(millSec);
        return sdf.format(date);
    }

}
