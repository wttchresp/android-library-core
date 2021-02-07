package com.wttch.android.core;

import android.app.Application;
import com.blankj.utilcode.util.CrashUtils;
import com.blankj.utilcode.util.CrashUtils.CrashInfo;
import com.blankj.utilcode.util.CrashUtils.OnCrashListener;
import com.wttch.android.core.log.BaseLogTree;
import timber.log.Timber;

public abstract class BaseApplication extends Application implements OnCrashListener {

  public abstract String defaultLogTag();

  @Override
  public void onCreate() {
    super.onCreate();
    Timber.plant(new BaseLogTree(defaultLogTag()));
    CrashUtils.init(this);
  }

  @Override
  public void onCrash(CrashInfo crashInfo) {
    Timber.e(crashInfo.toString());
  }
}
