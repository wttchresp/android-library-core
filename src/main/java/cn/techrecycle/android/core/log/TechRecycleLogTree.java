package cn.techrecycle.android.core.log;

import android.annotation.SuppressLint;
import android.util.Log;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

/**
 * 自定义 Timer, 不用每次 log 都添加 tag，如果未指定 tag 则使用默认的 tag:{@code DEFAULT_TAG}
 */
public class TechRecycleLogTree extends Timber.Tree {

  public static final String DEFAULT_TAG = "tech-recycle";
  private final String tag;

  public TechRecycleLogTree() {
    this(DEFAULT_TAG);
  }

  public TechRecycleLogTree(String tag) {
    this.tag = tag;
  }

  @SuppressLint("LogNotTimber")
  @Override
  protected void log(int priority, @Nullable String tag, @NotNull String message,
      @Nullable Throwable t) {
    String logTag = tag == null ? this.tag : tag;
    if (priority == Log.ASSERT) {
      Log.wtf(logTag, message);
    } else {
      Log.println(priority, logTag, message);
    }
    if (t != null) {
      Log.w(tag, t);
    }
  }
}
