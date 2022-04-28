package com.uuch.android_zxinglibrary;

import android.app.Application;
import android.util.DisplayMetrics;

import com.uuch.android_zxinglibrary.lib_zxing.DisplayUtil;
import com.uuch.android_zxinglibrary.lib_zxing.activity.ZXingLibrary;

/**
 * Created by aaron on 16/9/7.
 */

public class MApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

//        ZXingLibrary.initDisplayOpinion(this);
        initDisplayOpinion();
    }

    private void initDisplayOpinion() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        DisplayUtil.density = dm.density;
        DisplayUtil.densityDPI = dm.densityDpi;
        DisplayUtil.screenWidthPx = dm.widthPixels;
        DisplayUtil.screenhightPx = dm.heightPixels;
        DisplayUtil.screenWidthDip = DisplayUtil.px2dip(getApplicationContext(), dm.widthPixels);
        DisplayUtil.screenHightDip = DisplayUtil.px2dip(getApplicationContext(), dm.heightPixels);
    }
}
