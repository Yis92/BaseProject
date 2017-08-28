package com.yivideo.ui.adapter.viewholder;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.yivideo.R;
import com.yivideo.component.ImageLoader;

/**
 * Created by yivideo on 2017/8/23.
 */

public class MainViewHolder extends BaseViewHolder<String> {

    ImageView ivHead;

    public MainViewHolder(ViewGroup itemView) {
        super(itemView, R.layout.adapter_main_item);
        ivHead = $(R.id.iv_head);
    }

    @Override
    public void setData(String data) {
        super.setData(data);
        int width =  ((Activity)getContext()).getWindowManager().getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams params = ivHead.getLayoutParams();
        //设置图片的相对于屏幕的宽高比
        params.width = width/2;
        params.height =  (int) (200 + Math.random() * 400) ;
        ivHead.setLayoutParams(params);

        ImageLoader.load(getContext(), data, ivHead);
    }
}
