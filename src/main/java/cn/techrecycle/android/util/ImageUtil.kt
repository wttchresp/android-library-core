package cn.techrecycle.android.util

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.camera.core.ImageProxy
import androidx.camera.core.internal.utils.ImageUtil.imageToJpegByteArray

object ImageUtil {
  /**
   * 将 Image 代理类转换为 Bitmap
   */
  @SuppressLint("RestrictedApi")
  fun imageProxyToBitmap(imageProxy: ImageProxy?): Bitmap? {
    val bytes = imageProxy?.let { imageToJpegByteArray(it) }
    return bytes?.let {
      BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }
  }

  fun yuv_420_888toNv21(image: ImageProxy): ByteArray {
    val yPlane = image.planes[0]
    val uPlane = image.planes[1]
    val vPlane = image.planes[2]
    val yBuffer = yPlane.buffer
    val uBuffer = uPlane.buffer
    val vBuffer = vPlane.buffer
    yBuffer.rewind()
    uBuffer.rewind()
    vBuffer.rewind()
    val ySize = yBuffer.remaining()
    var position = 0
    val nv21 = ByteArray(ySize + image.width * image.height / 2)

    // Add the full y buffer to the array. If rowStride > 1, some padding may be skipped.
    for (row in 0 until image.height) {
      yBuffer[nv21, position, image.width]
      position += image.width
      yBuffer.position(
          Math.min(ySize, yBuffer.position() - image.width + yPlane.rowStride))
    }
    val chromaHeight = image.height / 2
    val chromaWidth = image.width / 2
    val vRowStride = vPlane.rowStride
    val uRowStride = uPlane.rowStride
    val vPixelStride = vPlane.pixelStride
    val uPixelStride = uPlane.pixelStride

    // Interleave the u and v frames, filling up the rest of the buffer. Use two line buffers to
    // perform faster bulk gets from the byte buffers.
    val vLineBuffer = ByteArray(vRowStride)
    val uLineBuffer = ByteArray(uRowStride)
    for (row in 0 until chromaHeight) {
      vBuffer[vLineBuffer, 0, Math.min(vRowStride, vBuffer.remaining())]
      uBuffer[uLineBuffer, 0, Math.min(uRowStride, uBuffer.remaining())]
      var vLineBufferPosition = 0
      var uLineBufferPosition = 0
      for (col in 0 until chromaWidth) {
        nv21[position++] = vLineBuffer[vLineBufferPosition]
        nv21[position++] = uLineBuffer[uLineBufferPosition]
        vLineBufferPosition += vPixelStride
        uLineBufferPosition += uPixelStride
      }
    }
    return nv21
  }
}