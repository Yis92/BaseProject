package com.yivideo.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.yivideo.ui.adapter.viewholder.MainViewHolder;

/**
 * Created by sunny on 2017/8/23.
 */

public class MainRecycleAdapter extends RecyclerArrayAdapter<String> {

    public MainRecycleAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(parent);
    }
}
