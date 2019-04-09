package com.wd.demo.net

import android.annotation.SuppressLint
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.*


object TrustAllCerts {
    fun createSSLSocketFactory(): SSLSocketFactory? {
        var sslSocketFactory: SSLSocketFactory? = null
        val sslContext = SSLContext.getInstance("SSL")

        sslContext.init(null, arrayOf<TrustManager>(TrustAllManager()), SecureRandom())

        sslContext.socketFactory
        return sslSocketFactory
    }

    class TrustAllManager : X509TrustManager {
        override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getAcceptedIssuers(): Array<X509Certificate?> {
            return arrayOfNulls(0)
        }

    }

    class TrustAllHostnameVerifier : HostnameVerifier {
        @SuppressLint("BadHostnameVerifier")
        override fun verify(hostname: String, session: SSLSession): Boolean {
            return true
        }
    }
}