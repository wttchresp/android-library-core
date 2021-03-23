package com.wttch.android.io;

import java.io.IOException;

public class TimeoutException extends IOException {

  public TimeoutException() {
  }

  public TimeoutException(String str) {
    super(str);
  }
}
