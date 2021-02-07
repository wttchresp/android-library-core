package com.wttch.android.supports

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.google.android.material.tabs.TabLayout


/**
 * 为 TabLayout 创建并添加新的 item
 *
 * @param name 项目的名称资源
 * @param icon 项目的图标资源
 */
fun TabLayout.addTab(@StringRes name: Int, @DrawableRes icon: Int): TabLayout = apply {
  val item = this.newTab()
  item.setText(name)
  item.setIcon(icon)
  this.addTab(item)
}


/**
 * 为 TabLayout 创建并添加新的 item
 *
 * @param name 项目的名称
 * @param icon 项目的图标资源
 */
fun TabLayout.addTab(name: String, @DrawableRes icon: Int): TabLayout = apply {
  val item = this.newTab()
  item.text = name
  item.setIcon(icon)
  this.addTab(item)
}