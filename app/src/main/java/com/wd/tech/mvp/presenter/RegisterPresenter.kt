package com.wd.tech.mvp.presenter

import android.content.Context
import com.wd.tech.bean.RegisterBean
import com.wd.tech.contract.IModelCallback
import com.wd.tech.contract.LoginContract
import com.wd.tech.contract.RegisterContract
import com.wd.tech.mvp.model.LoginModel
import com.wd.tech.mvp.model.RegisterModel

class RegisterPresenter : RegisterContract.RegisterPresenter {

    fun attach(iRegisterView: RegisterContract.IRegisterView) {
        this.iRegisterView = iRegisterView
        registerModel=RegisterModel()

    }
    override fun register(hashMap: HashMap<String, String>) {
        registerModel.register(hashMap,object :IModelCallback<RegisterBean>{
            override fun sucess(data: RegisterBean) {
                iRegisterView.success(data)
            }

            override fun failure(string: String) {
                iRegisterView.failure(string)
            }

        })
    }

    lateinit var registerModel: RegisterModel
    lateinit var iRegisterView:RegisterContract.IRegisterView

    fun detach(){
        if (iRegisterView!=null){
            iRegisterView==null
        }
    }
}