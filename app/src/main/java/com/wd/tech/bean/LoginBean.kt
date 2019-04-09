package com.wd.tech.bean

data class LoginBean(
    val message: String,
    val status:String,
    val result:Result
){
    data class Result(
        val userId:Int,
        val sessionId:String,
        val nickName :String,
        val phone:String,
        val pwd:String,
        val userName:String,
        val headPic:String,
        val whetherVip:Int,
        val whetherFaceId:Int
    )
}