package kr.co.highton.slacks.sim

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_c2c.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
* Created by Kinetic on 2018-06-02.
*/
class C2cFragment : Fragment() {

    private val items = java.util.ArrayList<Data>()
    private var recyclerView: RecyclerView? = null
    private var adapter: RecyclerAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_c2c, container, false)
        view.fab.setOnClickListener {
            items += Data("질문", "작성자", "1분 전", "질문있습니다!")
            recyclerView!!.adapter.notifyDataSetChanged()
        }
        recyclerView = view!!.findViewById(R.id.recyclerView)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        recyclerView!!.adapter = kr.co.highton.slacks.sim.RecyclerAdapter(items)
        adapter = recyclerView!!.adapter as RecyclerAdapter?

        Client.retrofitService.getQuestionList().enqueue(object : Callback<ArrayList<QuestionRepo>> {
            override fun onResponse(call: Call<ArrayList<QuestionRepo>>?, response: Response<ArrayList<QuestionRepo>>?) {
                val repo = response!!.body()

                when (response.code()) {
                    200 -> {
                        repo!!.indices.forEach {
                            items += Data(repo[it].id, repo[it].writer, repo[it].date, repo[it].content)
                            recyclerView!!.adapter.notifyDataSetChanged()
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<QuestionRepo>>?, t: Throwable?) {
                Log.v("C2cTest", "fail!!")
            }
        })
        return view
    }



}