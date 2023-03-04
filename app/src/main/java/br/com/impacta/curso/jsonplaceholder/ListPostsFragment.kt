package br.com.impacta.curso.jsonplaceholder

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.impacta.curso.jsonplaceholder.data.models.Post
import br.com.impacta.curso.jsonplaceholder.data.remote.JSONEndpoints
import br.com.impacta.curso.jsonplaceholder.data.remote.MyRetrofit
import br.com.impacta.curso.jsonplaceholder.databinding.FragmentListPostsBinding
import br.com.impacta.curso.jsonplaceholder.ui.adapters.RVAdaptador
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListPostsFragment : Fragment() {

    private var _binding: FragmentListPostsBinding? = null
    private val binding get() = _binding!!
    private val myRetrofit = MyRetrofit.getInstance("https://jsonplace.typicode.com/")
    private val endpoints = myRetrofit.create(JSONEndpoints::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListPostsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        endpoints.getPostList().enqueue(object : Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                response.body()?.let { lista ->
                    val adaptador = RVAdaptador(lista)
                    binding.rv.adapter = adaptador
                    binding.rv.layoutManager = LinearLayoutManager(requireContext())
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.e("IMPACTA", t.stackTraceToString())
            }

        })
    }
}