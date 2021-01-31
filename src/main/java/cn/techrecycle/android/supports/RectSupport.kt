package cn.techrecycle.android.supports

import android.graphics.Rect


/**
 * 将Rect向外扩展[size], 同时保证 left, top 不小于零, width 不小于 [width], height 不小于 [height]
 */
fun Rect.extend(size: Int, width: Int, height: Int): Rect {
  return Rect(
      (left - size).coerceAtLeast(0),
      (top - size).coerceAtLeast(0),
      (right + size).coerceAtMost(width),
      (bottom + size).coerceAtMost(height)
  )
}

/**
 * 判断rect是否在另一个rect内部
 */
fun Rect.isIn(rect: Rect): Boolean {
  return (this.left > rect.left).and(this.right < rect.right).and(this.top > rect.top).and(this.bottom < rect.bottom)
}