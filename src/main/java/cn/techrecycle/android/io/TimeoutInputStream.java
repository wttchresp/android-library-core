package cn.techrecycle.android.io;

import java.io.IOException;
import java.io.InputStream;

public class TimeoutInputStream extends InputStream {

  private final InputStream in;

  public TimeoutInputStream(InputStream in) {
    this.in = in;
  }

  /**
   * 在指定时间内读取, 如果超时没有数据则抛出 {@link TimeoutException} 异常
   *
   * @param timeout 超时时间:ms
   * @throws IOException 超时
   */
  public int read(long timeout) throws IOException {
    long timeoutOn = System.currentTimeMillis() + timeout;
    boolean canRead = false;
    boolean isTimeout = false;
    while (!canRead && !isTimeout) {
      canRead = this.available() > 0;
      isTimeout = System.currentTimeMillis() > timeoutOn;
    }
    if (canRead) {
      return this.read();
    } else {
      throw new TimeoutException();
    }
  }

  /**
   * 在指定时间内读取, 如果超时没有数据则抛出 {@link TimeoutException} 异常
   *
   * @param buf     要读取的数据保存的buffer
   * @param timeout 超时时间:ms
   * @throws IOException 超时
   */
  public int read(byte[] buf, long timeout) throws IOException {
    long timeoutOn = System.currentTimeMillis() + timeout;
    boolean canRead = false;
    boolean isTimeout = false;
    while (!canRead && !isTimeout) {
      canRead = this.available() == buf.length;
      isTimeout = System.currentTimeMillis() > timeoutOn;
    }
    if (canRead) {
      return this.read(buf);
    } else {
      throw new TimeoutException();
    }
  }

  @Override
  public int available() throws IOException {
    return in.available();
  }

  @Override
  public int read() throws IOException {
    return in.read();
  }
}
