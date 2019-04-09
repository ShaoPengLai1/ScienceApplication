package com.wd.tech.netWork

import com.wd.tech.apis.Apis
import com.wd.tech.bean.BannerShow
import com.wd.tech.bean.LoginBean
import com.wd.tech.bean.RegisterBean
import io.reactivex.Observable
import retrofit2.http.*

interface BaseApis {


    @POST(Apis.REGISTER_URL)
    @FormUrlEncoded
    fun register(@FieldMap hashMap: HashMap<String,String>):Observable<RegisterBean>

    @POST(Apis.LOGIN_URL)
    @FormUrlEncoded
    fun login(@FieldMap params: HashMap<String, String>): Observable<LoginBean>

    @GET
    fun bannerShow(@Url url: String, @QueryMap params: HashMap<String, String>): Observable<BannerShow>

}