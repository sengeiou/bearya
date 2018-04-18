package com.bearya.robot.household.api;

import com.bearya.robot.household.entity.BindDeviceList;
import com.bearya.robot.household.entity.KeyInfo;
import com.bearya.robot.household.entity.LoginInfo;
import com.bearya.robot.household.entity.ProductInfo;
import com.bearya.robot.household.http.retrofit.HttpRetrofitClient;

import retrofit2.http.Query;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

public class FamilyApiWrapper extends HttpRetrofitClient {
    private static FamilyApiWrapper trailApiWrapper;

    private FamilyApiWrapper() {

    }

    public static FamilyApiWrapper getInstance() {
        if (trailApiWrapper == null) {
            synchronized (FamilyApiWrapper.class) {
                if (trailApiWrapper == null) {
                    return new FamilyApiWrapper();
                }
            }
        }
        return trailApiWrapper;
    }

    public Observable<LoginInfo> getUserInfo(String code, String app) {
        return getService(FamilyApiService.class).getUserInfo(code, app).compose(this.applySchedulers());
    }

    public Observable<BindDeviceList> getDeviceList() {
        return getService(FamilyApiService.class).getDeviceList().compose(this.applySchedulers());
    }

    public Observable<String> bindDevice(String serial, String dtype) {
        return getService(FamilyApiService.class).bindDevice(serial, dtype).compose(this.applySchedulers());
    }

    public Observable<String> unBindDevice(String serial, String dtype) {
        return getService(FamilyApiService.class).unBindDevice(serial, dtype).compose(this.applySchedulers());
    }

    public Observable<KeyInfo> getMonitorKey(String deviceId, int uid) {
        return getService(FamilyApiService.class).getMonitorKey(deviceId, uid).compose(this.applySchedulers());
    }

    public Observable<ProductInfo> getProductCode(String url) {
        return getService(FamilyApiService.class).getProduceCode(url).compose(this.applySchedulers());
    }

    public FamilyApiService getService(Class clz) {
        super.setIsShowTips(true);
        return (FamilyApiService) super.getService(clz);
    }
}