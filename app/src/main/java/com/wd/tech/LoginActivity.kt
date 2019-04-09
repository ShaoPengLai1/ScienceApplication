package com.wd.tech

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.stx.xhb.xbanner.XBanner
import com.stx.xhb.xbanner.transformers.Transformer
import com.wd.tech.bean.BannerShow
import com.wd.tech.contract.BannerContract
import com.wd.tech.mvp.presenter.BannerPresenter
import com.wd.tech.apis.Apis
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity(),BannerContract.IBannerView {

    private lateinit var bannerPresenter: BannerPresenter
    val mImageUrl= mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        bannerPresenter=BannerPresenter()
        var params = HashMap<String, String>()
        bannerPresenter.attach(this)
        bannerPresenter.banners(Apis.BANNERSHOW_URL,params)
    }
    override fun success(bannerShow: BannerShow) {
        Toast.makeText(this,bannerShow.message,Toast.LENGTH_LONG).show()
        for (i in 0 until bannerShow.result.size) {
            mImageUrl.add(bannerShow.result[i].imageUrl)
            initImageData()
        }
    }

    private fun initImageData() {
        xbanner_home.setData(mImageUrl, null);
        xbanner_home.loadImage(XBanner.XBannerAdapter { banner, model, view, position ->
            Glide.with(this).load(mImageUrl.get(position)).into(view as ImageView)
        })
        xbanner_home.setPageTransformer(Transformer.Default);
        xbanner_home.setPageTransformer(Transformer.Alpha);
        xbanner_home.setPageTransformer(Transformer.ZoomFade);
        xbanner_home.setPageTransformer(Transformer.ZoomCenter);
        xbanner_home.setPageTransformer(Transformer.ZoomStack);
        xbanner_home.setPageTransformer(Transformer.Stack);
        xbanner_home.setPageTransformer(Transformer.Depth);
        xbanner_home.setPageTransformer(Transformer.Zoom);
        xbanner_home.setPageChangeDuration(0);
    }


    override fun failure(error: String) {
        Toast.makeText(this,error,Toast.LENGTH_LONG).show()
    }
}








