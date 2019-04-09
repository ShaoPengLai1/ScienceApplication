package com.wd.tech.netWork

import com.trello.rxlifecycle2.kotlin.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSession


class RetrofitManager private constructor() {


    lateinit var retrofit: Retrofit

    //单例模式
    companion object {
        val instance: RetrofitManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {

            RetrofitManager()
        }
    }

    fun init(string: String) {


        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
                )
            )
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .sslSocketFactory(RxUtils.createSSLSocketFactory())
            .hostnameVerifier(object : HostnameVerifier {
                override fun verify(hostname: String?, session: SSLSession?): Boolean {
                    return true
                }

            })
            .build()
        retrofit = Retrofit.Builder()
            .baseUrl(string)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    fun <T> createService(tClass: Class<T>): T {

        return retrofit.create(tClass)
    }


}






