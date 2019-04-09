package com.wd.tech.netWork

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object NetScheduler {
    fun <T> compose(): ObservableTransformer<T, T> {

        return ObservableTransformer {
                observable -> observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }
}