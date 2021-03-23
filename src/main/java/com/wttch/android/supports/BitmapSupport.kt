package com.wttch.android.supports

import android.graphics.Bitmap
import android.graphics.Rect
import androidx.core.util.Consumer
import com.wttch.android.util.BitmapUtils

fun Bitmap.saveTo(fileName: String, format: Bitmap.CompressFormat, callback: Consumer<Boolean>) {
  BitmapUtils.saveToFile(this, fileName, format, callback)
}

/**
 * 剪切图片
 *
 * @param rect 剪切的范围
 * @param size 向外扩展的范围
 */
fun Bitmap.clip(rect: Rect, size: Int = 0): Bitmap {
  val extRect = rect.extend(size, this.width, this.height)
  return Bitmap.createBitmap(this, extRect.left, extRect.top, extRect.width(), extRect.height())
}