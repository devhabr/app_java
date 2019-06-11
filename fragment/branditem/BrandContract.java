package com.example.water.marketplace.fragment.branditem;

import com.example.water.marketplace.model.StatusBrand;

import java.util.List;

/**
 * Created by water on 29.09.2017.
 */

public interface BrandContract {

    interface View{
        void refreshRecyclerVew(List<StatusBrand.Brand> storiesList);
    }

    interface Presenter{
       // void getBeforeNews(String date);
        void getListBrand();
    }

    interface model{
        //void getBeforeNews(CallBackLatestNews callback, String date);
        void getListBrand(CallBackLatestNews callback);
    }
}
