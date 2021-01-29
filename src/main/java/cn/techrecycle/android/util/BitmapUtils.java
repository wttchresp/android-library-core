package cn.techrecycle.android.util;

import android.graphics.Bitmap;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BitmapUtils {

  public static boolean saveToFile(Bitmap bitmap, String fileName, Bitmap.CompressFormat format) {
    OutputStream os = null;
    try {
      os = new BufferedOutputStream(new FileOutputStream(new File(fileName)));
      return bitmap.compress(format, 100, os);
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }
}
