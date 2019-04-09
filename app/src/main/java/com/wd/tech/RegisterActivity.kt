package com.wd.tech

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.wd.tech.bean.RegisterBean
import com.wd.tech.contract.RegisterContract
import com.wd.tech.mvp.presenter.LoginPresenter
import com.wd.tech.mvp.presenter.RegisterPresenter
import com.wd.tech.utils.RsaCoder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(),RegisterContract.IRegisterView,View.OnClickListener {


    private lateinit var registerPresenter: RegisterPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        registerPresenter= RegisterPresenter()
        reg_btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.reg_btn-> register()
        }
    }

    private fun register() {
        var params = HashMap<String, String>()
        params["nickName"] =nick_name.text.toString()
        params["phone"] = reg_phone.text.toString()
        params["pwd"] = RsaCoder.encryptByPublicKey(reg_pwd.text.toString())
        registerPresenter.attach(this)
        registerPresenter.register(params)
    }

    override fun success(registerBean: RegisterBean) {
        Toast.makeText(this,registerBean.message,Toast.LENGTH_LONG).show()
        var intent = Intent()
        intent.setClass(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun failure(error: String) {

    }
}
