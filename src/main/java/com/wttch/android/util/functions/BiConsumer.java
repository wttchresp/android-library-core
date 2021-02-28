package com.wttch.android.util.functions;

import androidx.annotation.NonNull;

@FunctionalInterface
public interface BiConsumer<T1, T2> {

  void apply(T1 t1, T2 t2);

  @NonNull
  default BiConsumer<T1, T2> andThen(@NonNull BiConsumer<T1, T2> then) {
    return (t1, t2) -> {
      apply(t1, t2);
      then.apply(t1, t2);
    };
  }

  default BiConsumer<T1, T2> andThen(Callback callback) {
    return (t1, t2) -> {
      apply(t1, t2);
      callback.call();
    };
  }
}
