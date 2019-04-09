package com.wd.tech.mvp.model

import android.annotation.SuppressLint
import com.wd.tech.bean.LoginBean
import com.wd.tech.contract.IModelCallback
import com.wd.tech.contract.LoginContract
import com.wd.tech.netWork.BaseApis
import com.wd.tech.netWork.NetScheduler
import com.wd.tech.netWork.RetrofitManager
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

class LoginModel : LoginContract.LoginModel{
    override fun login(hashMap: HashMap<String, String>, modelCallback: IModelCallback<LoginBean>) {
        RetrofitManager.instance.createService(BaseApis::class.java)
            .login(hashMap)
            .compose(NetScheduler.compose())

            .subscribe(object :Observer<LoginBean>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: LoginBean) {
                    modelCallback.sucess(t)
                }

                override fun onError(e: Throwable) {
                    modelCallback.failure(e.message!!)
                }
            })
    }


}