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

public class UserFragment extends BaseFragment {

    @BindView(R.id.tv_user)
    TextView tvUser;

    @Override
    protected int getLayout() {
        return R.layout.fragment_user;
    }

    @Override
    protected void lazyFetchData() {
        //测试懒加载
        tvUser.setText("个人中心& 当前时间是："+transferLongToDate("MM/dd/yyyy HH:mm:ss", System.currentTimeMillis()));
    }


    public String transferLongToDate(String dateFormat, Long millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = new Date(millSec);
        return sdf.format(date);
    }

}
