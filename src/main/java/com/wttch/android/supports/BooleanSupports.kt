package com.wttch.android.supports

import androidx.core.util.Supplier


/**
 * 如果 Boolean 为真则返回 [ifTrue], 否则返回 [ifFalse].
 */
fun <T> Boolean.ifElse(ifTrue: T, ifFalse: T): T {
  return if (this) ifTrue else ifFalse
}

fun <T> Boolean.ifElseThen(ifTrue: Supplier<T>, ifFalse: Supplier<T>): T {
  return if (this) ifTrue.get() else ifFalse.get()
}

fun <T> Boolean.ifElseThen(ifTrue: T, ifFalse: Supplier<T>): T {
  return if (this) ifTrue else ifFalse.get()
}

fun <T> Boolean.ifElseThen(ifTrue: Supplier<T>, ifFalse: T): T {
  return if (this) ifTrue.get() else ifFalse
}