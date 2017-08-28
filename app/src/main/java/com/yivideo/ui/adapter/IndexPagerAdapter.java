package com.yivideo.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.yivideo.R;
import com.yivideo.component.ImageLoader;
import com.yivideo.utils.EventUtil;

import java.util.List;

/**
 * Created by yivideo on 2017/8/23.
 */

public class IndexPagerAdapter extends StaticPagerAdapter {

    private Context context;
    private List<String> list;

    public IndexPagerAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public View getView(ViewGroup container, final int position) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setBackgroundResource(R.mipmap.ic_launcher);
        //加载图片
        ImageLoader.load(context, list.get(position), imageView);
        //点击事件
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventUtil.showToast(context, "" + position);
            }
        });
        return imageView;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
