package com.uuch.android_zxinglibrary.lib_zxing.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.uuch.android_zxinglibrary.lib_zxing.R;


/**
 * Initial the camera
 * <p>
 * 默认的二维码扫描Activity
 */
public class CaptureActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        com.uuch.android_zxinglibrary.lib_zxing.activity.CaptureFragment captureFragment = new com.uuch.android_zxinglibrary.lib_zxing.activity.CaptureFragment();
        captureFragment.setAnalyzeCallback(analyzeCallback);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_zxing_container, captureFragment).commit();
        captureFragment.setCameraInitCallBack(new com.uuch.android_zxinglibrary.lib_zxing.activity.CaptureFragment.CameraInitCallBack() {
            @Override
            public void callBack(Exception e) {
                if (e == null) {

                } else {
                    Log.e("TAG", "callBack: ", e);
                }
            }
        });

    }

    /**
     * 二维码解析回调函数
     */
    com.uuch.android_zxinglibrary.lib_zxing.activity.CodeUtils.AnalyzeCallback analyzeCallback = new com.uuch.android_zxinglibrary.lib_zxing.activity.CodeUtils.AnalyzeCallback() {
        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(com.uuch.android_zxinglibrary.lib_zxing.activity.CodeUtils.RESULT_TYPE, com.uuch.android_zxinglibrary.lib_zxing.activity.CodeUtils.RESULT_SUCCESS);
            bundle.putString(com.uuch.android_zxinglibrary.lib_zxing.activity.CodeUtils.RESULT_STRING, result);
            resultIntent.putExtras(bundle);
            CaptureActivity.this.setResult(RESULT_OK, resultIntent);
            CaptureActivity.this.finish();
        }

        @Override
        public void onAnalyzeFailed() {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(com.uuch.android_zxinglibrary.lib_zxing.activity.CodeUtils.RESULT_TYPE, com.uuch.android_zxinglibrary.lib_zxing.activity.CodeUtils.RESULT_FAILED);
            bundle.putString(com.uuch.android_zxinglibrary.lib_zxing.activity.CodeUtils.RESULT_STRING, "");
            resultIntent.putExtras(bundle);
            CaptureActivity.this.setResult(RESULT_OK, resultIntent);
            CaptureActivity.this.finish();
        }
    };
}