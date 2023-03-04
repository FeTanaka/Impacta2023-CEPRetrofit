package br.com.impacta.curso.jsonplaceholder.data.remote

import br.com.impacta.curso.jsonplaceholder.data.models.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface JSONEndpoints {

    @Headers('Authorization_Code: ')
    @GET("/posts")
    fun getPostList(): Call<List<Post>>

}