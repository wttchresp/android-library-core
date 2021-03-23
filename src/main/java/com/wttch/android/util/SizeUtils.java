package com.wttch.android.util;

import android.content.res.Resources;

/**
 * 页面 size 相关的工具类
 */
public final class SizeUtils {

  /**
   * 将 dp 值转换为 px 数值.
   *
   * @param dpValue dp值
   * @return 转换成的 px 值
   */
  public static int dp2px(final float dpValue) {
    final float scale = Resources.getSystem().getDisplayMetrics().density;
    return (int) (dpValue * scale + 0.5f);
  }

  /**
   * 将 px 值转换为 dp 值
   *
   * @param pxValue px 值
   * @return 转换成的 dp 值
   */
  public static int px2dp(final float pxValue) {
    final float scale = Resources.getSystem().getDisplayMetrics().density;
    return (int) (pxValue / scale + 0.5f);
  }
}
