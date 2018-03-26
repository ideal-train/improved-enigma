package com.xprogect.x_library.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.xprogect.x_library.R;

import butterknife.ButterKnife;

/**
 * 底部弹窗
 */
public abstract class BaseBottomDialogFragment extends DialogFragment {
    //资源ID
    private int layoutId;
    private static final String LAYOUT_ID = "layoutID";
    View mView;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    //距离底部
    private int y;

    public BaseBottomDialogFragment() {
    }


    //    public static BaseBottomDialogFragment newInstance(String param1, String param2) {
//        BaseBottomDialogFragment fragment = new BaseBottomDialogFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    public static BaseBottomDialogFragment newInstance(int layoutId) {
//        BaseBottomDialogFragment fragment = new BaseBottomDialogFragment();
//        Bundle args = new Bundle();
//        args.putInt(LAYOUT_ID, layoutId);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

            layoutId = getArguments().getInt(LAYOUT_ID);
        }
    }

    private View view = null;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity(), R.style.ActionSheetDialogStyle);
        if (view == null) {
//             view = LayoutInflater.from(getActivity()).inflate(layoutId, null);
            view = LayoutInflater.from(getActivity()).inflate(setContentViewID(), null);
        }
        ButterKnife.bind(this, view);
        dialog.setContentView(view);

        initView(dialog);
        return dialog;
    }

    @LayoutRes
    public abstract int setContentViewID();

    public abstract void initView(Dialog dialog);

    /**
     * 设置底部高度
     *
     * @return 距离底部 Y 值
     */
    public abstract int setY();

    protected abstract int setHeight();

    protected abstract int setWidth();

    @Override
    public void onStart() {
        super.onStart();

        Window dialogWindow = getDialog().getWindow();
        WindowManager.LayoutParams lp = null;
        if (dialogWindow != null) {
            lp = dialogWindow.getAttributes();
            if (lp != null) {
                lp.y = setY();
                lp.gravity = Gravity.BOTTOM;
                lp.height = setHeight() > 0 ? setHeight() : WindowManager.LayoutParams.WRAP_CONTENT;
                lp.width = setWidth() > 0 ? setWidth() : WindowManager.LayoutParams.MATCH_PARENT;
            }
            dialogWindow.setAttributes(lp);
        }
    }


}