package com.booboomx.rxjavaretrofitdemo.utils;

import android.view.View;

/**
 * Created by libo on 2017/7/9.
 * https://my.oschina.net/u/1376187/blog/172792
 */

public class ViewUtils {

    /**
     * 获取在parent里的相对坐标位置
     getLeft();
     getTop();
     getBottom();
     getRight();

     获取在屏幕中的绝对位置
     getLocalVisibleRect();
     getGlobalVisibleRect();
     getLocationOnScreen();
     getLocationInWindow();
     * @param view
     * @return
     */
    public static  int[] getLocation(View view){

        int[] position=new int[2];
        int height = view.getHeight();
        position[0]=height;
        position[1]=view.getWidth();
        return position;



    }
}
