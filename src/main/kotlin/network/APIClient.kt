package network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class APIClient(
    private val token: String,
    private val base_url: String,
) {
    private val client by lazy {
        OkHttpClient.Builder().addInterceptor {
            val requests = it
                .request()
                .newBuilder()
                .addHeader(
                    "X-Auth-Token", token
                ).build()
            it.proceed(requests)
        }.build()
    }

    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(base_url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
