package com.wd.tech.netWork;

import android.content.SharedPreferences;
import com.wd.tech.app.App;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class CustomIntercept implements Interceptor {
    private  String ak = "0110010010000";
    private String Content_Type = "application/x-www-form-urlencoded";
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
//        SharedPreferences preferences = App.getApplication().getSharedPreferences("User", Context.MODE_PRIVATE);
//        String userId = preferences.getString("userId", "");
//        String sessionId = preferences.getString("sessionId", "");
        Request.Builder builder1 = request.newBuilder();
        builder1.method(request.method(), request.body());
        builder1.addHeader("ak",ak);
        builder1.addHeader("Content_Type",Content_Type);
//        if (!TextUtils.isEmpty(userId) && !TextUtils.isEmpty(sessionId)) {
//            builder1.addHeader("userId", userId);
//            builder1.addHeader("sessionId", sessionId);
//        }

        Request build = builder1.build();

        return chain.proceed(build);
    }
}
