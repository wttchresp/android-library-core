package com.wttch.android.supports

/**
 * 如果 Boolean 为真则返回 [ifTrue], 否则返回 [ifFalse].
 */
fun <T> Boolean.ifElse(ifTrue: T, ifFalse: T): T {
  return if (this) ifTrue else ifFalse
}