package com.wd.tech.contract

import com.wd.tech.bean.BannerShow

interface BannerContract {
    open abstract class BannerPresenter{
        abstract fun banners(url: String, hashMap: HashMap<String,String>)
    }
    interface BannerModel {
        fun banners(url: String, params: HashMap<String, String>, modelCallback: IModelCallback<BannerShow>)
    }
    interface IBannerView{
        fun success(bannerShow: BannerShow)
        fun failure(error:String)
    }
}