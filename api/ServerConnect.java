package com.example.water.marketplace.api;

import com.example.water.marketplace.model.StatusBrand;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by water on 29.09.2017.
 */

public class ServerConnect {

    private static final int DEFAULT_TIMEOUT = 5;
    private ServerConnectSetting serverConnectSetting;
    private static ServerConnect serverConnect;
    private Retrofit retrofit;
//Connect server
    private ServerConnect() {
        OkHttpClient.Builder httpcientBuilder = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpcientBuilder.build())
                .baseUrl(ServerConfig.WATER_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        serverConnectSetting = retrofit.create(ServerConnectSetting.class);
    }


    public static ServerConnect getInstance(){
        if (serverConnect == null) {
            synchronized (ServerConnect.class){
                if (serverConnect == null){
                    serverConnect = new ServerConnect();
                }
            }
        }
        return serverConnect;
    }
//getNewsRss
    public void getListBrand(Subscriber<StatusBrand> subscriber){
        serverConnectSetting.getLatestNews()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
/*
    public void getBeforeNews(Subscriber<LatestNews> subscriber, String date){
        zhiHuService.getBeforeNews(date)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getNews(Subscriber<News> subscriber, int id){
        zhiHuService.getNews(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    public void getStoryExtra(Subscriber<StoryExtra> subscriber, int id){
        zhiHuService.getStroyExtra(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getComment(Subscriber<Comment> subscriber, int id) {
        zhiHuService.getComments(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    */
}
