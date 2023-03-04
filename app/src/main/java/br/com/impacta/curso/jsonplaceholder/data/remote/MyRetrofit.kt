package br.com.impacta.curso.jsonplaceholder.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit {
    companion object {
        fun getInstance(url:String): Retrofit {
            return Retrofit
                .Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}