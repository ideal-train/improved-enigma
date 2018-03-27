package com.xprogect;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.xprogect.application.R;
import com.xprogect.fragment.HomeHotFragment;
import com.xprogect.x_library.base.BaseTooBarActivity;
import com.xprogect.x_library.utils.MyLog;
import com.xprogect.x_library.utils.StatusBarUtil;
import com.xprogect.x_library.widget.KeyRadioGroupV1;

import butterknife.BindView;


public class MainActivity extends BaseTooBarActivity {
    @BindView(R.id.rg_bottom)
    KeyRadioGroupV1 rgBottom;
    @BindView(R.id.fake_status_bar)
    View fakeStatusBar;

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTranslucentForImageView(MainActivity.this, 0, null);
    }

    @Override
    public int setContentViewID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        hitToolBar();
        Logger.d("------------------------------------");
        MyLog.d("MainActivity", "onCreate:" + "");
        final Bundle bundle = new Bundle();
        rgBottom.setOnCheckedChangeListener(new KeyRadioGroupV1.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(KeyRadioGroupV1 group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_hot:
                        bundle.putString("home", "首页");
                        switchFragment(HomeHotFragment.getInstance(), bundle);
                        break;
                    case R.id.rb_wiki:
                        bundle.putString("home", "发现");
                        switchFragment(HomeHotFragment.getInstance(), bundle);
                        break;
                    case R.id.rb_chats:
                        bundle.putString("home", "聊天");
                        switchFragment(HomeHotFragment.getInstance(), bundle);
                        break;
                    case R.id.rb_mine:
                        bundle.putString("home", "我的");
                        switchFragment(new HomeHotFragment(), bundle);
                        fakeStatusBar.setVisibility(View.GONE);
                        break;
                    default:
                        break;
                }
            }
        });
        bundle.putString("home", "首页");
        switchFragment(HomeHotFragment.getInstance(), bundle);
    }


    public void switchFragment(Fragment fragment, Bundle bundle) {
        try {
            fakeStatusBar.setVisibility(View.VISIBLE);
//            FragmentManager manager = getChildFragmentManager();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            if (bundle != null) {
                fragment.setArguments(bundle);
            }
            ft.replace(R.id.fl_body, fragment);
            ft.commit();
        } catch (Exception exceptione) {
        }
    }
}
