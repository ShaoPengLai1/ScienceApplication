package com.wd.tech.contract

import android.content.Context
import com.wd.tech.bean.LoginBean

interface LoginContract {
    open abstract class LoginPresenter{
        abstract fun login(hashMap: HashMap<String,String>)
    }
    interface LoginModel {
        fun login(params: HashMap<String, String>, modelCallback: IModelCallback<LoginBean>)
    }
    interface ILoginView{
        fun success(loginBean: LoginBean)
        fun failure(error:String)
    }
}