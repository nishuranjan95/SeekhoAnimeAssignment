package com.example.seekhoanimeassignment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.seekhoanimeassignment.Utils.ViewUtil
import com.example.seekhoanimeassignment.data.model.TopRatedData
import com.example.seekhoanimeassignment.databinding.ActivityMainBinding
import com.example.seekhoanimeassignment.di.component.DaggerActivityComponent
import com.example.seekhoanimeassignment.di.module.ActivityModule
import com.example.seekhoanimeassignment.ui.MainViewModel
import com.example.seekhoanimeassignment.ui.adapter.TopRatingAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private var datalist= arrayListOf<TopRatedData>()
    private lateinit var binding: ActivityMainBinding

    @Inject lateinit var viewModel: MainViewModel
    private lateinit var adapter: TopRatingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        getDept()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRCV()
        observeData()

    }

    private fun setRCV(){
        adapter= TopRatingAdapter(datalist){
            val intent= Intent(this,DetailsActivity::class.java)
            intent.putExtra("mail_d",it)
            startActivity(intent)
        }
        binding.rcv.let {
            it.layoutManager=LinearLayoutManager(this)
            it.adapter=adapter
        }
    }


    private fun observeData() {

        viewModel.fetchData()

        lifecycleScope.launch {
            viewModel.topRatedData.collectLatest {
                when(it){
                    is State.Success ->{
                        ViewUtil.hide(binding.pb)
                        Log.d("success",it.data.toString())
                        if(it.data.data!=null) {
                            datalist.clear()
                            datalist.addAll(it.data.data!!)
                            adapter.notifyDataSetChanged()
                        }
                    }
                    is State.Failure ->{
                        ViewUtil.hide(binding.pb)
                        Log.d("Error",it.error)
                    }
                    is State.Loading ->{
                        ViewUtil.show(binding.pb)
                        Log.d("Loading",it.msg)
                    }
                }
            }
        }
    }

    private fun getDept(){
        DaggerActivityComponent.builder()
            .applicationComponent((application as SeekhoApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)
    }
}