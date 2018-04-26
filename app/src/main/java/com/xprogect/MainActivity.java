package com.xprogect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.xprogect.application.R;
import com.xprogect.enums.OhterWay;
import com.xprogect.find.FindFragment;
import com.xprogect.home.HomeFragment;
import com.xprogect.testbugly.BuglyTestActivity;
import com.xprogect.x_library.base.BaseTooBarActivity;
import com.xprogect.x_library.utils.MyLog;
import com.xprogect.x_library.utils.StatusBarUtil;
import com.xprogect.x_library.widget.KeyRadioGroupV1;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseTooBarActivity {
    private long exitTime = 0;
    @BindView(R.id.rg_bottom)
    KeyRadioGroupV1 rgBottom;
    @BindView(R.id.fake_status_bar)
    View fakeStatusBar;

    @Override
    protected void setStatusBar() {
        super.setStatusBar();
    }

    protected void setStatusBarAll() {
        StatusBarUtil.setTransparentForImageViewInFragment(MainActivity.this, null);
    }

    @Override
    public int setContentViewID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        hitToolBar();
        MyLog.d("MainActivity", "onCreate:" + "");
        final Bundle bundle = new Bundle();
        rgBottom.setOnCheckedChangeListener(new KeyRadioGroupV1.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(KeyRadioGroupV1 group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_hot:
                        bundle.putInt("home", OhterWay.HOME_0);
                        switchFragment(HomeFragment.getInstance(), bundle);
                        break;
                    case R.id.rb_wiki:
                        bundle.putInt("home", OhterWay.FIND_1);
                        switchFragment(FindFragment.getInstance(), bundle);
                        break;
                    case R.id.rb_chats:
                        bundle.putInt("home", OhterWay.CHAT_2);
                        switchFragment(HomeFragment.getInstance(), bundle);
                        break;
                    case R.id.rb_mine:
                        bundle.putInt("home", OhterWay.MINE_3);
                        switchFragment(new HomeFragment(), bundle);
//                        fakeStatusBar.setVisibility(View.GONE);
                        setStatusBarAll();
                        break;
                    default:
                        break;
                }
            }
        });
        bundle.putInt("home", OhterWay.HOME_0);
        switchFragment(HomeFragment.getInstance(), bundle);
    }


    public void switchFragment(Fragment fragment, Bundle bundle) {
        try {
//            fakeStatusBar.setVisibility(View.VISIBLE);
//            FragmentManager manager = getChildFragmentManager();
            setStatusBar();
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


    @OnClick(R.id.rb_fabu)
    protected void mClick() {
        Intent mIntent = new Intent(this, BuglyTestActivity.class);
        startActivity(mIntent);
    }


    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - exitTime) < 2000) {
            super.onBackPressed();
            finishAll();
        } else {
            toast("再按一次退出程序");
            exitTime = currentTime;
        }
    }

}
