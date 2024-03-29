package com.example.water.marketplace.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.water.marketplace.R;

import butterknife.ButterKnife;


public abstract class BaseFragment<V, T extends BasePresenter<V>> extends Fragment {
    protected T mPresenter;
    protected View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        if (mView == null) {
            mView = view;
        }
        ButterKnife.bind(this, mView);
        mPresenter = createPresenter();

        return view;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detechView();
        }
    }

    protected abstract int getLayoutId();

    protected abstract T createPresenter();
}
