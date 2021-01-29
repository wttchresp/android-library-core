package cn.techrecycle.android.supports

import android.content.res.TypedArray

/**
 * 在 TypedArray 中获取字符串, 如果不存在则返回给定的默认的字符串
 */
fun TypedArray.getString(id: Int, default: String): String {
  return getString(id) ?: default
}