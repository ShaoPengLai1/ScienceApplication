package com.wd.tech.bean

data class BannerShow(
    val message: String,
    val result: List<Result>,
    val status: String
) {
    data class Result(
        val imageUrl: String,
        val jumpUrl: String,
        val rank: Int,
        val title: String
    )
}