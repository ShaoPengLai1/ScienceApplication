package com.wd.tech.mvp.model

import com.wd.tech.bean.BannerShow
import com.wd.tech.contract.BannerContract
import com.wd.tech.contract.IModelCallback
import com.wd.tech.netWork.BaseApis
import com.wd.tech.netWork.NetScheduler
import com.wd.tech.netWork.RetrofitManager
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class BannerModel:BannerContract.BannerModel {
    override fun banners(url: String, params: HashMap<String, String>, modelCallback: IModelCallback<BannerShow>) {
        RetrofitManager.instance.createService(BaseApis::class.java)

            .bannerShow(url,params)
            .compose(NetScheduler.compose())
            .subscribe(object : Observer<BannerShow> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: BannerShow) {
                    modelCallback.sucess(t)
                }

                override fun onError(e: Throwable) {
                    modelCallback.failure(e.message!!)
                }
            })
    }

}