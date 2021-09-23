package entity

import com.google.gson.annotations.SerializedName

data class Pocketmon (
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)
