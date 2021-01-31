package cn.techrecycle.android.supports

import android.graphics.Bitmap
import androidx.core.util.Consumer
import cn.techrecycle.android.util.BitmapUtils

fun Bitmap.saveTo(fileName: String, format: Bitmap.CompressFormat, callback: Consumer<Boolean>) {
  BitmapUtils.saveToFile(this, fileName, format, callback)
}