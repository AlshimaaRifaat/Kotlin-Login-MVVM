package com.example.kotlinlogin

import android.app.Service
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

//import javax.swing.UIManager.put


class LoginViewModel : ViewModel() {


    public var listProductsMutableLiveData: MutableLiveData<LoginModel>? = null
    private lateinit var context: Context


    public fun getData(
        Email: String,
        Password:String,
        context: Context
    ): LiveData<LoginModel> {
        listProductsMutableLiveData = MutableLiveData<LoginModel>()
        this.context = context
        getDataValues(Email,Password)


        //  return listProductsMutableLiveData
        return listProductsMutableLiveData as MutableLiveData<LoginModel>

    }

    private fun getDataValues(Email: String,Password:String) {
        var service = ApiClient.getClient()?.create(com.example.kotlinlogin.Service::class.java)
        val call = service?.userLogin(Email,Password)
//        call.enqueue(object : retrofit2.Callback<List<DataModel>>)


        call?.enqueue(object : Callback, retrofit2.Callback<LoginModel> {
            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {

                if (response.code() == 200) {
                    listProductsMutableLiveData?.setValue(response.body()!!)

                } else {
                    listProductsMutableLiveData?.setValue(null)
                }
            }

            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                listProductsMutableLiveData?.setValue(null)

            }
        })
    }
}