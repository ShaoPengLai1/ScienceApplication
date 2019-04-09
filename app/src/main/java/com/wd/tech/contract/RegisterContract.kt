package com.wd.tech.contract

import android.content.Context
import com.wd.tech.bean.RegisterBean

interface RegisterContract {

    interface RegisterPresenter{
        fun register(hashMap: HashMap<String,String>)
    }
    interface RegisterModel{
        fun register(hashMap: HashMap<String, String>, modelCallback: IModelCallback<RegisterBean>)
    }
    interface IRegisterView{
        fun success(registerBean: RegisterBean)
        fun failure(error:String)
    }
}
