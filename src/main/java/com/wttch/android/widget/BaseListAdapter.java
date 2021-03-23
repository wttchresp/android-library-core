package com.wttch.android.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 集合列表数据的是适配器
 *
 * @param <T> 列表内元素类型
 */
public abstract class BaseListAdapter<T> extends BaseAdapter {

  /**
   * 列表数据
   */
  private final List<T> dataList = new LinkedList<>();

  /**
   * 上下文
   */
  private final Context context;

  public BaseListAdapter(Context context) {
    this.context = context;
  }

  public BaseListAdapter(Context context, List<T> data) {
    this.context = context;
    setData(data);
  }

  public BaseListAdapter(Context context, T[] data) {
    this.context = context;
    setData(data);
  }

  /**
   * 设置适配器数据, 同时通知数据改变.
   *
   * @param data 重新设置适配器数据
   */
  public void setData(List<T> data) {
    if (data != null && !data.isEmpty()) {
      dataList.clear();
      dataList.addAll(data);
      notifyDataSetChanged();
    }
  }

  /**
   * 设置适配器数据, 同时通知数据改变.
   *
   * @param data 重新设置的适配器数组数据
   */
  public void setData(T[] data) {
    if (data != null && data.length > 0) {
      setData(Arrays.asList(data));
    }
  }

  /**
   * 向适配器添加数据, 同时通知数据改变.
   *
   * @param data 要添加的数据
   */
  public void addAll(List<T> data) {
    if (data != null && !data.isEmpty()) {
      dataList.addAll(data);
      notifyDataSetChanged();
    }
  }

  /**
   * 向适配器中添加指定数组的数据, 同时通知数据改变.
   *
   * @param data 要添加的数据数组
   * @see #addAll(List)
   */
  public void addAll(T[] data) {
    addAll(Arrays.asList(data));
  }

  /**
   * 添加元素, 同时通知数据改变.
   *
   * @param data 要添加的元素
   */
  public void add(T data) {
    if (data != null) {
      dataList.add(data);
      notifyDataSetChanged();
    }
  }

  /**
   * 在适配器中移除指定的元素, 同时通知数据改变.
   *
   * @param element 要移除的数据
   */
  public void remove(T element) {
    if (element != null) {
      dataList.remove(element);
      notifyDataSetChanged();
    }
  }

  /**
   * 在适配器中移除数组中的元素, 同时通知数据改变.
   *
   * @param elements 要移除的元素数组
   * @see #removeAll(List)
   */
  public void removeAll(T[] elements) {
    if (elements != null) {
      removeAll(Arrays.asList(elements));
    }
  }

  /**
   * 在适配器中移除给定列表中的所有元素, 同时通知数据改变.
   *
   * @param elements 要移除元素列表
   */
  public void removeAll(List<T> elements) {
    if (elements != null && !elements.isEmpty()) {
      dataList.removeAll(elements);
      notifyDataSetChanged();
    }
  }

  /**
   * 更新指定位置的数据, 同时通知数据改变.
   *
   * @param position 要修改数据的位置
   * @param element  要替换的数据
   */
  public void set(int position, T element) {
    if (checkPosition(position)) {
      dataList.set(position, element);
      notifyDataSetChanged();
    }
  }

  /**
   * 清除适配器中的所有元素
   */
  public void clear() {
    dataList.clear();
    notifyDataSetChanged();
  }
  
  public List<T> getItems() {
    return dataList;
  }

  @Override
  public int getCount() {
    return dataList.size();
  }

  @Override
  public T getItem(int position) {
    return checkPosition(position) ? dataList.get(position) : null;
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public abstract View getView(int position, View convertView, ViewGroup parent);

  private boolean checkPosition(int position) {
    return position >= 0 && position < dataList.size();
  }

  protected Drawable getDrawable(@DrawableRes int resId) {
    return ContextCompat.getDrawable(context, resId);
  }

  protected String getString(@StringRes int resId) {
    return context.getString(resId);
  }

  protected String getString(@StringRes int resId, Object... formatArgs) {
    return context.getString(resId, formatArgs);
  }

  protected int getColor(@ColorRes int resId) {
    return ContextCompat.getColor(context, resId);
  }

  public Context getContext() {
    return context;
  }
}
