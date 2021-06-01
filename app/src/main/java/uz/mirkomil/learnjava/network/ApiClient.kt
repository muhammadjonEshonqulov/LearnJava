package uz.mirkomil.learnjava.network

import Prefs
import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.HttpUrl
import okhttp3.Request
import java.util.concurrent.TimeUnit

object ApiClient {

//    private const val BASE_URL = "http://api.intalim.uz/api/"

    private var retrofit: Retrofit? = null

    private fun getClient(token:String): OkHttpClient {
        val builder = OkHttpClient().newBuilder().addInterceptor { chain ->
            val originalRequest: Request = chain.request()
            val url: HttpUrl = originalRequest.url.newBuilder()
                .addQueryParameter("token", token)
                .addQueryParameter("Content-Type", "application/json")
                .build()
            val requestBuilder: Request.Builder = originalRequest.newBuilder()
                .url(url)
            val request: Request = requestBuilder.build()
            chain.proceed(request)
        }
            .connectTimeout(10000L, TimeUnit.MILLISECONDS)
            .readTimeout(10000L, TimeUnit.MILLISECONDS)
            .writeTimeout(10000L, TimeUnit.MILLISECONDS)


        return builder.build()
    }

    fun instanse(context: Context): Retrofit {

        if (retrofit == null) {

            retrofit = Retrofit.Builder()
                .client(getClient(""))
                .baseUrl("http://myapi.intalim.uz/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
//            }
        }
        return retrofit!!
    }

    fun inalidate() {
        retrofit = null
    }

}