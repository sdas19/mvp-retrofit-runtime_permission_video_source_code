package ittoolstraining.com.mvpsampleapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/photos")
    fun getPhotos() : Call<List<ResponseModel>>
}