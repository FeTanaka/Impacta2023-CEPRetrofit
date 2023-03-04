package br.com.impacta.curso.jsonplaceholder.data.models

data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
) {
    fun getIdString() = this.id.toString()

    fun getUserIdString() = this.userId.toString()
}