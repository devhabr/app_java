package com.example.water.marketplace.fragment.branditem;

import android.util.Log;

import com.example.water.marketplace.model.StatusBrand;

import java.util.List;

/**
 * Created by water on 29.09.2017.
 */

public class BrandPresenter implements BrandContract.Presenter {

    private static final String TAG =  BrandPresenter.class.getSimpleName();
    private BrandContract.View view;
    private BrandContract.model model;

    public BrandPresenter(BrandContract.View view) {
        this.view = view;
        model = new BrandListModel();
    }

/*
    @Override
    public void getBeforeNews(String date) {
        model.getBeforeNews(new CallBackLatestNews() {
            @Override
            public void result(List<StatusBrand.BrandJson> list) {
                view.refreshRecyclerVew(list);
            }
        }, date);
    }
*/
    @Override
    public void getListBrand() {
        Log.d(TAG, "getLatestNews: ");
        model.getListBrand(new CallBackLatestNews() {
            @Override
            public void result(List<StatusBrand.Brand> list) {
                view.refreshRecyclerVew(list);
            }
        });
    }
}
