package com.wd.tech.contract

interface IModelCallback<T> {
    fun sucess(data: T)
    fun failure(string: String)
}