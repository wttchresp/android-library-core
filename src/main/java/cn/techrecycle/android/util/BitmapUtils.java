package cn.techrecycle.android.util;

import android.graphics.Bitmap;
import androidx.core.util.Consumer;
import com.blankj.utilcode.util.StringUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Executors;

public class BitmapUtils {

  /**
   * 将 bitmap 保存到指定路径位置
   */
  public static boolean saveToFile(Bitmap bitmap, String fileName, Bitmap.CompressFormat format) {
    return saveToFile(bitmap, fileName, format, 100);
  }

  public static boolean saveToFile(Bitmap bitmap, String fileName,
      Bitmap.CompressFormat format, int quality) {
    if (bitmap == null || StringUtils.isEmpty(fileName)) {
      return false;
    }
    try {
      OutputStream os = new BufferedOutputStream(new FileOutputStream(new File(fileName)));
      return bitmap.compress(format, 100, os);
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * 将 bitmap 保存到指定路径位置, 异步操作
   */
  public static void saveToFile(Bitmap bitmap, String fileName, Bitmap.CompressFormat format,
      Consumer<Boolean> callback) {
    Executors.newSingleThreadExecutor().submit(() -> {
      boolean rst = saveToFile(bitmap, fileName, format);
      if (callback != null) {
        callback.accept(rst);
      }
    });
  }
}
