package com.wd.tech.mvp.presenter

import com.wd.tech.bean.BannerShow
import com.wd.tech.contract.BannerContract
import com.wd.tech.contract.IModelCallback
import com.wd.tech.mvp.model.BannerModel

class BannerPresenter : BannerContract.BannerPresenter() {
    override fun banners(url: String, hashMap: HashMap<String, String>) {
        bannerModel.banners(url,hashMap,object :IModelCallback<BannerShow>{
            override fun sucess(data: BannerShow) {
                iBannerView.success(data)
            }

            override fun failure(string: String) {
                iBannerView.failure(string)
            }
        })
    }

    private lateinit var bannerModel: BannerModel
    lateinit var iBannerView: BannerContract.IBannerView
    fun attach(iBannerView: BannerContract.IBannerView) {
        this.iBannerView = iBannerView
        bannerModel = BannerModel()

    }

    fun detach(){
        if (iBannerView!=null){
            iBannerView==null
        }
    }
}