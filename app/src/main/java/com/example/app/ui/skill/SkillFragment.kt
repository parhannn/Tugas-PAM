package com.example.app.ui.skill

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import kotlin.collections.ArrayList
import java.util.*

private const val t10 = "t1"
private const val t20 = "t2"

class SkillFragment : Fragment() {
    private var t1: String? = null

    private lateinit var adapter : MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var skillArrayList : ArrayList<Skill>
    private lateinit var imageId : Array<Int>
    private lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            t1 = it.getString(t10)
            t1 = it.getString(t20)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_skill, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        // di initialize dulu sebelum dipanggil, pindah panggil fungsi datainitialize ke sebelum array di panggil, ini hasilnya masih null karna belum di initialize (lateinit)
        dataInitialize()
        adapter = MyAdapter(skillArrayList)
        recyclerView.adapter = adapter
        searchView = view.findViewById(R.id.search_action)

        //dataInitialize()

        adapter.onItemClick = {
            val intent = Intent(requireContext(), SkillDetail::class.java)
            intent.putExtra("skill", it)
            startActivity(intent)
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<Skill>()
            for (i in skillArrayList) {
                if (i.heading.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(context, "No Data Found", Toast.LENGTH_SHORT).show()
            }
            else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun dataInitialize(){
        skillArrayList = arrayListOf<Skill>()

        imageId = arrayOf(
            R.drawable.cpp_logo,
            R.drawable.py_logo,
            R.drawable.html_logo,
            R.drawable.css_logo,
            R.drawable.js_logo,
            R.drawable.sql_logo,
            R.drawable.cpp_logo,
            R.drawable.py_logo,
            R.drawable.html_logo,
            R.drawable.css_logo,
            R.drawable.js_logo
        )

        heading = arrayOf(
            getString(R.string.text_cpp),
            getString(R.string.text_py),
            getString(R.string.text_html),
            getString(R.string.text_css),
            getString(R.string.text_js),
            getString(R.string.text_sql),
            getString(R.string.text_cpp),
            getString(R.string.text_py),
            getString(R.string.text_html),
            getString(R.string.text_css),
            getString(R.string.text_js)
        )

        getUserData()

    }

    private fun getUserData() {

        for (i in imageId.indices){
            val skill = Skill(imageId[i],heading[i])
            skillArrayList.add(skill)

        }

    }

}