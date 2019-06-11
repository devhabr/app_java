package com.example.water.marketplace.fragment.branditem;

import android.util.Log;

import com.example.water.marketplace.api.ServerConnect;
import com.example.water.marketplace.model.StatusBrand;

import rx.Subscriber;

public class BrandListModel implements BrandContract.model {

    private static final String TAG = "NewsModel";

/*
    @Override
    public void getBeforeNews(final CallBackLatestNews callback, String date) {
        Subscriber subscriber = new Subscriber<StatusBrand>() {

            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(StatusBrand statusBrand) {
                callback.result(statusBrand.getModelBrandList());
            }
        };
        ServerConnect.getInstance().getBeforeNews(subscriber, date);
    }
*/

    @Override
    public void getListBrand(final CallBackLatestNews callback) {
        Subscriber subscriber = new Subscriber<StatusBrand>() {

            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(StatusBrand statusBrand) {
                Log.d(TAG, "onNext: ");
                callback.result(statusBrand.getModelBrandList());
            }
        };
        ServerConnect.getInstance().getListBrand(subscriber);
    }

}