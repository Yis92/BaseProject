package com.yivideo.ui.activity;

import android.os.Bundle;

import com.yivideo.R;
import com.yivideo.app.App;
import com.yivideo.base.BaseActivity;
import com.yivideo.presenter.MainPresenter;
import com.yivideo.ui.view.MainView;
import com.yivideo.utils.EventUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    public static final String Set_Theme_Color = "Set_Theme_Color";
    public final static String Banner_Stop = "Banner_Stop";

    private Long firstTime = 0L;

    @BindView(R.id.main_view)
    MainView mainView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
    }



    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 1500) {
            EventUtil.showToast(this, "再按一次退出");
            firstTime = secondTime;
        } else {
            App.getInstance().exitApp();
        }
    }

//    @Override
//    public void onColorSelection(@NonNull ColorChooserDialog dialog, @ColorInt int selectedColor) {
//        this.setTheme(R.style.PurpleTheme);
//        PreUtils.setCurrentTheme(this, Theme.Purple);
//        PreUtils.putString(this, Constants.PRIMARYCOLOR, "#9c27b0");
//        PreUtils.putString(this, Constants.TITLECOLOR, "#ffffff");


//        if (selectedColor == ThemeUtils.getThemeColor(this, R.attr.colorPrimary)) {
//            return;
//        }
//
//        if (selectedColor == getResources().getColor(R.color.colorBluePrimary)) {
//            this.setTheme(R.style.BlueTheme);
//            PreUtils.setCurrentTheme(this, Theme.Blue);
//            PreUtils.putString(this, Constants.PRIMARYCOLOR, "#2196F3");
//            PreUtils.putString(this, Constants.TITLECOLOR, "#ffffff");
//        } else if (selectedColor == getResources().getColor(R.color.colorRedPrimary)) {
//            this.setTheme(R.style.RedTheme);
//            PreUtils.setCurrentTheme(this, Theme.Red);
//            PreUtils.putString(this, Constants.PRIMARYCOLOR, "#F44336");
//            PreUtils.putString(this, Constants.TITLECOLOR, "#ffffff");
//        } else if (selectedColor == getResources().getColor(R.color.colorBrownPrimary)) {
//            this.setTheme(R.style.BrownTheme);
//            PreUtils.setCurrentTheme(this, Theme.Brown);
//            PreUtils.putString(this, Constants.PRIMARYCOLOR, "#795548");
//            PreUtils.putString(this, Constants.TITLECOLOR, "#ffffff");
//        } else if (selectedColor == getResources().getColor(R.color.colorGreenPrimary)) {
//            this.setTheme(R.style.GreenTheme);
//            PreUtils.setCurrentTheme(this, Theme.Green);
//            PreUtils.putString(this, Constants.PRIMARYCOLOR, "#4CAF50");
//            PreUtils.putString(this, Constants.TITLECOLOR, "#ffffff");
//        } else if (selectedColor == getResources().getColor(R.color.colorPurplePrimary)) {
//            this.setTheme(R.style.PurpleTheme);
//            PreUtils.setCurrentTheme(this, Theme.Purple);
//            PreUtils.putString(this, Constants.PRIMARYCOLOR, "#9c27b0");
//            PreUtils.putString(this, Constants.TITLECOLOR, "#ffffff");
//        } else if (selectedColor == getResources().getColor(R.color.colorTealPrimary)) {
//            this.setTheme(R.style.TealTheme);
//            PreUtils.setCurrentTheme(this, Theme.Teal);
//            PreUtils.putString(this, Constants.PRIMARYCOLOR, "#009688");
//            PreUtils.putString(this, Constants.TITLECOLOR, "#ffffff");
//        } else if (selectedColor == getResources().getColor(R.color.colorPinkPrimary)) {
//            this.setTheme(R.style.PinkTheme);
//            PreUtils.setCurrentTheme(this, Theme.Pink);
//            PreUtils.putString(this, Constants.PRIMARYCOLOR, "#E91E63");
//            PreUtils.putString(this, Constants.TITLECOLOR, "#ffffff");
//        } else if (selectedColor == getResources().getColor(R.color.colorDeepPurplePrimary)) {
//            this.setTheme(R.style.DeepPurpleTheme);
//            PreUtils.setCurrentTheme(this, Theme.DeepPurple);
//            PreUtils.putString(this, Constants.PRIMARYCOLOR, "#673AB7");
//            PreUtils.putString(this, Constants.TITLECOLOR, "#ffffff");
//        } else if (selectedColor == getResources().getColor(R.color.colorOrangePrimary)) {
//            this.setTheme(R.style.OrangeTheme);
//            PreUtils.setCurrentTheme(this, Theme.Orange);
//            PreUtils.putString(this, Constants.PRIMARYCOLOR, "#FF9800");
//            PreUtils.putString(this, Constants.TITLECOLOR, "#ffffff");
//        } else if (selectedColor == getResources().getColor(R.color.colorIndigoPrimary)) {
//            this.setTheme(R.style.IndigoTheme);
//            PreUtils.setCurrentTheme(this, Theme.Indigo);
//            PreUtils.putString(this, Constants.PRIMARYCOLOR, "#3F51B5");
//            PreUtils.putString(this, Constants.TITLECOLOR, "#ffffff");
//        } else if (selectedColor == getResources().getColor(R.color.colorLightGreenPrimary)) {
//            this.setTheme(R.style.LightGreenTheme);
//            PreUtils.setCurrentTheme(this, Theme.LightGreen);
//            PreUtils.putString(this, Constants.PRIMARYCOLOR, "#8BC34A");
//            PreUtils.putString(this, Constants.TITLECOLOR, "#ffffff");
//        } else if (selectedColor == getResources().getColor(R.color.colorDeepOrangePrimary)) {
//            this.setTheme(R.style.DeepOrangeTheme);
//            PreUtils.setCurrentTheme(this, Theme.DeepOrange);
//            PreUtils.putString(this, Constants.PRIMARYCOLOR, "##FF5722");
//            PreUtils.putString(this, Constants.TITLECOLOR, "#ffffff");
//        } else if (selectedColor == getResources().getColor(R.color.colorLimePrimary)) {
//            this.setTheme(R.style.LimeTheme);
//            PreUtils.setCurrentTheme(this, Theme.Lime);
//            PreUtils.putString(this, Constants.PRIMARYCOLOR, "#CDDC39");
//            PreUtils.putString(this, Constants.TITLECOLOR, "#ffffff");
//        } else if (selectedColor == getResources().getColor(R.color.colorBlueGreyPrimary)) {
//            this.setTheme(R.style.BlueGreyTheme);
//            PreUtils.setCurrentTheme(this, Theme.BlueGrey);
//            PreUtils.putString(this, Constants.PRIMARYCOLOR, "#CDDC39");
//            PreUtils.putString(this, Constants.TITLECOLOR, "#ffffff");
//        } else if (selectedColor == getResources().getColor(R.color.colorCyanPrimary)) {
//            this.setTheme(R.style.CyanTheme);
//            PreUtils.setCurrentTheme(this, Theme.Cyan);
//            PreUtils.putString(this, Constants.PRIMARYCOLOR, "#00BCD4");
//            PreUtils.putString(this, Constants.TITLECOLOR, "#ffffff");
//        } else if (selectedColor == getResources().getColor(android.R.color.black)) {
//            this.setTheme(R.style.BlackTheme);
//            PreUtils.setCurrentTheme(this, Theme.Black);
//            PreUtils.putString(this, Constants.PRIMARYCOLOR, "#000000");
//            PreUtils.putString(this, Constants.TITLECOLOR, "#0aa485");
//        }
//        EventBus.getDefault().post("", Set_Theme_Color);
//    }
}