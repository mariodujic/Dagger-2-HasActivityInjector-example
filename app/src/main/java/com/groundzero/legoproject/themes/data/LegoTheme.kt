package com.groundzero.legoproject.themes.data

import com.google.gson.annotations.SerializedName

data class LegoTheme(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("parent_id")
    val parentId: Int? = null
) {
    override fun toString() = name
}