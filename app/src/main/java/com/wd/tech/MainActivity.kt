package com.wd.tech

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.wd.tech.bean.LoginBean
import com.wd.tech.contract.LoginContract
import com.wd.tech.mvp.presenter.LoginPresenter
import com.wd.tech.utils.RsaCoder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),LoginContract.ILoginView ,View.OnClickListener{


    private lateinit var loginPresenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginPresenter = LoginPresenter()
        login_btn.setOnClickListener(this)
        reg_text.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.login_btn-> login()
            R.id.reg_text -> register()
        }
    }

    private fun register() {
        var intent = Intent()
        intent.setClass(this,RegisterActivity::class.java)
        startActivity(intent)

    }

    private fun login() {
        var params = HashMap<String, String>()

        params["phone"] = phone.text.toString()
        params["pwd"] = RsaCoder.encryptByPublicKey(pwd.text.toString())
        loginPresenter.attach(this)
        loginPresenter.login(params)
    }

    override fun success(loginBean: LoginBean) {

        Toast.makeText(this,loginBean.message,Toast.LENGTH_LONG).show()
        var intent = Intent()
        intent.setClass(this,LoginActivity::class.java)
        startActivity(intent)
    }

    override fun failure(error: String) {
        Toast.makeText(this,"2222",Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        loginPresenter.detach()
    }
}
