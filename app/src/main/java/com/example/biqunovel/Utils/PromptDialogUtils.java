package com.example.biqunovel.Utils;

import android.app.Activity;

import com.example.biqunovel.View.promptlibrary.PromptDialog;

/**
 * author : liuwen
 * e-mail : liuwen370494581@163.com
 * time   : 2019/05/28 11:01
 * desc   :
 */
public class PromptDialogUtils {
    private static PromptDialogUtils instance;
    private PromptDialog promptDialog;


    public PromptDialogUtils() {
    }

    public static PromptDialogUtils getInstance() {
        if (null == instance) {
            synchronized (PromptDialogUtils.class) {
                if (null == instance) {
                    instance = new PromptDialogUtils();
                }
            }
        }
        return instance;
    }

    public void init(Activity activity) {
        if (promptDialog == null) {
            promptDialog = new PromptDialog(activity);
            promptDialog.getDefaultBuilder().touchAble(true).round(10);
        }
    }

    public void showPromptDialog(String message) {
        promptDialog.showLoading(message);
    }

    public void hidePromptDialog() {
        promptDialog.dismiss();

    }

}
