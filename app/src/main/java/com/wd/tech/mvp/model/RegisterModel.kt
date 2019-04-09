package com.wd.tech.mvp.model

import android.content.Context
import com.wd.tech.apis.Apis
import com.wd.tech.bean.RegisterBean
import com.wd.tech.contract.IModelCallback
import com.wd.tech.contract.RegisterContract
import com.wd.tech.netWork.BaseApis
import com.wd.tech.netWork.NetScheduler
import com.wd.tech.netWork.RetrofitManager
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class RegisterModel :RegisterContract.RegisterModel {
    override fun register(
        hashMap: HashMap<String, String>,
        modelCallback: IModelCallback<RegisterBean>
    ) {
        RetrofitManager.instance.createService(BaseApis::class.java).register(hashMap)
            .compose(NetScheduler.compose())
            .subscribe(object : Observer<RegisterBean> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: RegisterBean) {
                    modelCallback?.sucess(t)
                }

                override fun onError(e: Throwable) {
                    modelCallback.failure(e.message!!)
                }

            })
    }
}