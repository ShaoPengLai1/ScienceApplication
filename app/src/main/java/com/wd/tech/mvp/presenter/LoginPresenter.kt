package com.wd.tech.mvp.presenter

import com.wd.tech.bean.LoginBean
import com.wd.tech.contract.IModelCallback
import com.wd.tech.contract.LoginContract
import com.wd.tech.mvp.model.LoginModel

class LoginPresenter : LoginContract.LoginPresenter() {
    private lateinit var loginModel: LoginModel
    lateinit var iLoginView: LoginContract.ILoginView
    fun attach(iLoginView: LoginContract.ILoginView) {
        this.iLoginView = iLoginView
        loginModel = LoginModel()

    }
    override fun login(hashMap: HashMap<String, String>) {
        loginModel.login(hashMap,object :IModelCallback<LoginBean>{
            override fun sucess(data: LoginBean) {
                iLoginView.success(data)
            }

            override fun failure(string: String) {
                iLoginView.failure(string)
            }
        })
    }
    fun detach(){
        if (iLoginView!=null){
            iLoginView==null
        }
    }
}