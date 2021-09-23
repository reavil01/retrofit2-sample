package network

import entity.PocketmonList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("pokemon?")
    fun doGetPoketmonList(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<PocketmonList>
}

