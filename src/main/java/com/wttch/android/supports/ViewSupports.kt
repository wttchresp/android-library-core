package com.wttch.android.supports

import android.view.View

/**
 * 隐藏视图 gone 方式
 * @param gone 是否隐藏, 如果为 false 则为显示
 */
fun View.gone(gone: Boolean) {
  if (gone) {
    this.visibility = View.GONE
  } else {
    this.visibility = View.VISIBLE
  }
}

/**
 * 隐藏视图 invisible 模式
 * @param hide 是否隐藏, 如果为 false 则为显示
 */
fun View.hide(hide: Boolean) {
  if (hide) {
    this.visibility = View.INVISIBLE
  } else {
    this.visibility = View.VISIBLE
  }
}