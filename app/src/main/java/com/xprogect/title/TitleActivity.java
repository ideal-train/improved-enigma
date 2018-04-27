package com.xprogect.title;

import android.content.DialogInterface;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.xprogect.application.R;
import com.xprogect.enums.OhterWay;
import com.xprogect.x_library.base.BaseTooBarActivity;
import com.xprogect.x_library.utils.DeviceUtils;
import com.xprogect.x_library.utils.DialogUtil;
import com.xprogect.x_library.utils.StatusBarUtil;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/3/28
 * function：
 */
public class TitleActivity extends BaseTooBarActivity implements DialogInterface.OnClickListener {
    @OhterWay.Flavour
    private int page;
    @BindView(R.id.fg_tv)
    TextView mFgtv;

    @Override
    public int setContentViewID() {
        return R.layout.fragment_home_hot;
    }

    @Override
    public void initView() {
        page = getIntent().getIntExtra("page", 0);
        switch (page) {
            case OhterWay.CHAT_2:
                setRightTxtTitleBar(OhterWay.getFlavour(page), "发布");
                break;
            case OhterWay.FIND_1:
                break;
            case OhterWay.HOME_0:
                setTitle(OhterWay.getFlavour(page));
                StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary), 0);
                StatusBarUtil.setDarkMode(this);
                break;
            case OhterWay.MINE_3:
                getLayoutInflater().inflate(R.layout.bottom_bar, getBaseToolBar());
                break;
            default:
                break;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (page != OhterWay.MINE_3) {
                mToolTarTitle.setTransitionName("ShowTitle");
            }
        }
        String mDeviceUtils =
                "\n获取应用程序名称--" + DeviceUtils.getAppName(this)
                        + "\n版本号--" + DeviceUtils.getVersionCode(this)
                        + "\n版本名--" + DeviceUtils.getVersionName(this)
                        + "\n判断设备是否root--" + DeviceUtils.isDeviceRoot()
                        + "\n获取设备厂商--" + DeviceUtils.getManufacturer()
                        + "\n获取设备型号--" + DeviceUtils.getModel()
                        + "\n获取设备系统版本号--" + DeviceUtils.getSDKVersion()
                        + "\n获取设备系统版本名--" + DeviceUtils.getSDKRelease()
                        + "\n获取设备AndroidID--" + DeviceUtils.getAndroidID(this)
                        + "\n获取设备MAC地址--" + DeviceUtils.getMacAddress(this)
                        + "\n判断当前设备是否是手机--" + DeviceUtils.isPhone(this);
        mFgtv.append(mDeviceUtils);
    }


    @Override
    public void rightAction() {
        super.rightAction();
//        AlertDialog dialog=DialogUtil.getAlertDialog(this,"正文","按钮");
//        dialog.show();
        DialogUtil.successDialog(this, "正文", this);
        toast("点击了右上角");
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        toast("点击了确定");
    }
}
