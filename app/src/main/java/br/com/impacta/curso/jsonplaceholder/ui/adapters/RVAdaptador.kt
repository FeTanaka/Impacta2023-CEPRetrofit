package br.com.impacta.curso.jsonplaceholder.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.impacta.curso.jsonplaceholder.data.models.Post
import br.com.impacta.curso.jsonplaceholder.databinding.PostItemBinding

class RVAdaptador(private val listaPosts: List<Post>, private val teste: Boolean): RecyclerView.Adapter<RVAdaptador.RVViewHolder>() {

    inner class RVViewHolder(private val binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.post = post
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PostItemBinding.inflate(inflater, parent, false)
        return RVViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        holder.bind(listaPosts[position])
    }

    override fun getItemCount(): Int = listaPosts.size

}