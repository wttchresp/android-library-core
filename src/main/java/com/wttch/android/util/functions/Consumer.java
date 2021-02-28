package com.wttch.android.util.functions;

import java.util.Objects;

@FunctionalInterface
public interface Consumer<T> {

  void accept(T t);

  default Consumer<T> andThen(Consumer<? super T> after) {
    Objects.requireNonNull(after);
    return (T t) -> {
      accept(t);
      after.accept(t);
    };
  }

  default Consumer<T> andThen(Callback callback) {
    Objects.requireNonNull(callback);
    return (T t) -> {
      accept(t);
      callback.call();
    };
  }
}