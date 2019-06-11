package com.example.water.marketplace.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by water on 29.09.2017.
 */

public class BasePresenter<V> {
    protected Reference<V> mViewRefer;

    public V getView() {
        return mViewRefer.get();
    }

    public void attachView(V view) {
        mViewRefer = new WeakReference<V>(view);
    }

    public void detechView() {
        if (mViewRefer != null) {
            mViewRefer.clear();
            mViewRefer = null;
        }
    }
}
