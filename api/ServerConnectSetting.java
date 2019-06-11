package com.example.water.marketplace.api;

import com.example.water.marketplace.model.StatusBrand;

import com.example.water.marketplace.model.account.LoginBody;
import com.example.water.marketplace.model.account.LoginUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by water on 29.09.2017.
 */

public interface ServerConnectSetting {
    @GET("GetBrand.php")
    Observable<StatusBrand> getLatestNews();


    @POST("UserAccount/affiliates/login")
    Call<LoginUser> login(@Body LoginBody loginBody);
/*
    @GET("api/4/news/before/{date}")
    Observable<LatestNews> getBeforeNews(@Path("date") String dateString);

    @GET("api/4/news/{id}")
    Observable<News> getNews(@Path("id") int id);

    @GET("api/4/story/{id}/long-comments")
    Observable<Comment> getComments(@Path("id") int id);

    @GET("api/4/story-extra/{id}")
    Observable<StoryExtra> getStroyExtra(@Path("id") int id);
    */
}
