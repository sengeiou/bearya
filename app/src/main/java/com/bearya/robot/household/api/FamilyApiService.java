package com.bearya.robot.household.api;

import com.bearya.robot.household.entity.BindDeviceList;
import com.bearya.robot.household.entity.KeyInfo;
import com.bearya.robot.household.entity.LoginInfo;
import com.bearya.robot.household.entity.ProductInfo;
import com.bearya.robot.household.http.retrofit.HttpResult;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface FamilyApiService {
    @POST("v1/client/wxlogin")
    Observable<HttpResult<LoginInfo>> getUserInfo(@Query("code") String code, @Query("app") String app);
    @POST("v1/client/device/list")
    Observable<HttpResult<BindDeviceList>> getDeviceList();
    @POST("v1/client/device/bind")
    Observable<HttpResult<String>> bindDevice(@Query("serial") String serial, @Query("dtype") String dtype);
    @POST("v1/client/device/unbind")
    Observable<HttpResult<String>> unBindDevice(@Query("serial") String serial, @Query("dtype") String dtype);
    @POST("v1/service/live/getKey")
    Observable<HttpResult<KeyInfo>> getMonitorKey(@Query("device_id") String device_id, @Query("uid") int uid);
    @POST("v1/client/device/qrnum")
    Observable<HttpResult<ProductInfo>> getProduceCode(@Query("url") String url);
}