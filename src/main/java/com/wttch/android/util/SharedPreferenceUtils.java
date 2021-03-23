package com.wttch.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.core.util.Consumer;
import com.blankj.utilcode.util.ActivityUtils;

public class SharedPreferenceUtils {

  private final static String DEFAULT_SHARED_PREFERENCE_NAME = "default-shared-preference";
  private static String sharedPreferenceName = DEFAULT_SHARED_PREFERENCE_NAME;

  /**
   * 获取保存的值
   */
  public static String getString(String key) {
    return getSharedPreferences().getString(key, null);
  }

  /**
   * 设置保存的值
   */
  public static void setString(String key, String value) {
    edit(editor -> editor.putString(key, value));
  }

  /**
   * 移除值
   */
  public static void removeString(String key) {
    edit(editor -> editor.remove(key));
  }

  private static void edit(Consumer<Editor> editor) {
    Editor edit = getSharedPreferences().edit();
    editor.accept(edit);
    edit.apply();
  }

  private static SharedPreferences getSharedPreferences() {
    return ActivityUtils.getTopActivity()
        .getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE);
  }

  /**
   * 初始化 SharedPreferenceUtils, 主要是指定使用的 SharedPreference 的名称.
   */
  public static void init(String name) {
    if (!SharedPreferenceUtils.sharedPreferenceName.equals(DEFAULT_SHARED_PREFERENCE_NAME)) {
      throw new RuntimeException("SharedPreferenceUtils has been init.");
    }
    SharedPreferenceUtils.sharedPreferenceName = name;
  }
}
