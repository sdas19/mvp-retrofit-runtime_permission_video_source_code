package ittoolstraining.com.mvpsampleapp

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivityPresenter(val mainActivityView : MainActivityContract.View) : MainActivityContract.Presenter {


    lateinit var retrofit: Retrofit
    private val BASE_URL = "https://jsonplaceholder.typicode.com"
    val TAG = MainActivityPresenter::class.java.simpleName

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    override fun makeApiCall() {

        val apiService = retrofit.create(ApiService::class.java)

        apiService.getPhotos().enqueue(object : Callback<List<ResponseModel>>
        {
            override fun onFailure(call: Call<List<ResponseModel>>, t: Throwable) {
                mainActivityView.showToastInView(t.localizedMessage)
            }

            override fun onResponse(call: Call<List<ResponseModel>>, response: Response<List<ResponseModel>>) {
                Log.e(TAG,response.body().toString())
                mainActivityView.showToastInView(response.body().toString())
            }
        }
        )
    }


}