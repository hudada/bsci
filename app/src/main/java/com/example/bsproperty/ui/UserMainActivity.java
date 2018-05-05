package com.example.bsproperty.ui;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.TextView;

import com.example.bsproperty.MyApplication;
import com.example.bsproperty.R;
import com.example.bsproperty.eventbus.LoginEvent;
import com.example.bsproperty.utils.SpUtils;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserMainActivity extends BaseActivity {


    @BindView(R.id.btn1)
    TextView btn1;
    @BindView(R.id.btn2)
    TextView btn2;
    @BindView(R.id.btn3)
    TextView btn3;
    @BindView(R.id.btn4)
    TextView btn4;
    @BindView(R.id.tvadd)
    TextView tvadd;
    @BindView(R.id.tvmine)
    TextView tvmine;
    private long backTime;

    @Override
    protected void initView(Bundle savedInstanceState) {
        MyApplication.getInstance().setUserBean(SpUtils.getUserBean(this));

        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.CALL_PHONE,
                    Manifest.permission.READ_LOGS,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.SET_DEBUG_APP,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.GET_ACCOUNTS,
                    Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginEvent(LoginEvent event) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    protected int getRootViewId() {
        return R.layout.activity_user_main;
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - backTime < 2000) {
            super.onBackPressed();
        } else {
            showToast(this, "再按一次，退出程序");
            backTime = System.currentTimeMillis();
        }
        backTime = System.currentTimeMillis();
    }


    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.tvadd, R.id.tvmine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(new Intent(this, CiPaiActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(this, CiInfoActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(this, MyCiActivity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(this, ShouCangActivity.class));
                break;
            case R.id.tvadd:
                startActivity(new Intent(this, WriteActivity.class));
                break;
            case R.id.tvmine:
                startActivity(new Intent(this, MyActivity.class));
                break;
        }
    }


}
