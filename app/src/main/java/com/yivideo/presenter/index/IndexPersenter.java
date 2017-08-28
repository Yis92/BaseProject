package com.yivideo.presenter.index;

import android.support.annotation.NonNull;

import com.yivideo.base.RxPresenter;
import com.yivideo.presenter.contract.index.IndexContract;
import com.yivideo.utils.Preconditions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunny on 2017/8/28.
 */

public class IndexPersenter extends RxPresenter implements IndexContract.Persenter {

    IndexContract.View mView;

    public IndexPersenter(@NonNull IndexContract.View mView) {
        mView = Preconditions.checkNotNull(mView);
        mView.setPresenter(this);
        this.mView = mView;
        getData();
    }

    @Override
    public void getData() {
        //省略网络请求获取内容...
        List<String> list1 = new ArrayList<>();
        list1.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=674545784,3413606991&fm=26&gp=0.jpg");
        list1.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503468830702&di=a41060934af82f5922710dc58bf64fe0&imgtype=0&src=http%3A%2F%2Ft1.niutuku.com%2F960%2F51%2F51-612392.jpg");
        list1.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503468604114&di=1e64a0994a1ecac03f6e1ebb2a9b4d00&imgtype=0&src=http%3A%2F%2Fimglf1.ph.126.net%2FtCAMd5QRewAJSb4CoIj22A%3D%3D%2F960674095523503219.jpg");
        list1.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503468878602&di=1b55acf2c74c821ed78fefb1cde5c40d&imgtype=0&src=http%3A%2F%2Fi9.download.fd.pchome.net%2Ft_960x600%2Fg1%2FM00%2F07%2F13%2FooYBAFNLVAqIEjgKABnYd9yBPIQAABdzgIJ_YwAGdiP514.jpg");


        List<String> list2 = new ArrayList<>();
        list2.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503469037775&di=e1fb7c5a1be7cef94bfc6be766ff3684&imgtype=0&src=http%3A%2F%2Fwww.pp3.cn%2Fuploads%2F201405%2F13657844445.jpg");
        list2.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503469037774&di=50bcb9c945bf0771b460f8770d3443b0&imgtype=0&src=http%3A%2F%2Fp1.gexing.com%2Fshaitu%2F20130217%2F1521%2F512084ef24570.jpg");
        list2.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503469037774&di=ee1481022c50ecd6c9f45c8f824e1f09&imgtype=0&src=http%3A%2F%2Fwww.pp3.cn%2Fuploads%2F201509%2F2015091902.jpg");
        list2.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503469037774&di=64d18191c8c992eccb3fb70d5308b8bf&imgtype=0&src=http%3A%2F%2Fwww.pp3.cn%2Fuploads%2F201412%2F2014123021.jpg");
        list2.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503469037774&di=7f8d14648b64f80c08d73a161fcbbb2a&imgtype=0&src=http%3A%2F%2Ftupian.enterdesk.com%2Fuploadfile%2F2012%2F0712%2F20120712021535150.jpg");
        list2.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503469098590&di=9f15f3d8f9b7878ba818712e1f9231b2&imgtype=jpg&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D2795257978%2C688423977%26fm%3D214%26gp%3D0.jpg");
        list2.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503469037774&di=c6d781e1f8b14c67ef5a2c736d45df2e&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F6%2F57cd3454a539c.jpg");
        list2.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503469037773&di=9101cabc6bf9607d429cfe3d294ad59f&imgtype=0&src=http%3A%2F%2Fwww.550990.com%2Fupload%2Fphoto%2F00%2F01%2F71%2F42%2F17142.jpg");
        list2.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503469037773&di=75575ebafa16c9f093ecb1c5cbea5f23&imgtype=0&src=http%3A%2F%2Fimage1.92bizhi.com%2Fanimal_dogs--06_27-1920x1440.jpg");
        list2.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503469037772&di=16d1d5ac154b6aa948cbf8b9033d5804&imgtype=0&src=http%3A%2F%2Fwww.550990.com%2Fupload%2Fphoto%2F00%2F01%2F71%2F34%2F17134.jpg");
        list2.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503469037772&di=694d6a36b1b9e600f447c1333bbfddf5&imgtype=0&src=http%3A%2F%2Fwww.pp3.cn%2Fuploads%2F201508%2F2015081501.jpg");
        mView.showContent(list1,list2);
    }
}
