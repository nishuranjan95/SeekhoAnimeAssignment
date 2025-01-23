package com.example.seekhoanimeassignment

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.seekhoanimeassignment.Utils.ViewUtil
import com.example.seekhoanimeassignment.data.model.AnimeDetailData
import com.example.seekhoanimeassignment.databinding.ActivityDetailsBinding
import com.example.seekhoanimeassignment.di.component.DaggerActivityComponent
import com.example.seekhoanimeassignment.di.module.ActivityModule
import com.example.seekhoanimeassignment.ui.DetailsViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    @Inject lateinit var viewModel: DetailsViewModel
    private var mail_id=0
    override fun onCreate(savedInstanceState: Bundle?) {
        getDept()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent!=null){
            mail_id=intent.getIntExtra("mail_id",0)
        }

        observeData()

    }

    private fun observeData() {

        viewModel.fetchData(mail_id.toString())

        lifecycleScope.launch {
            viewModel.detailData.collectLatest {
                when(it){
                    is State.Success ->{
                        ViewUtil.hide(binding.pb)
                        Log.d("success",it.data.toString())
                        if(it.data.data!=null) {
                           setUI(it.data.data!!)
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

    private fun setUI(data: AnimeDetailData) {
        binding.let {
            it.rating.text=data.score
            it.countEp.text= data.episodes.toString()
            it.title.text=data.title
            it.synpsis.text=data.synopsis
            if(data.trailer!=null && data.trailer!!.embed_url!=null){
                ViewUtil.hide(it.img)
                loadURL(data.trailer!!.embed_url)
            }else {
                ViewUtil.show(it.img)
                ViewUtil.hide(it.webView)

                Glide.with(binding.img.context)
                    .load(data.images?.webp?.large_image_url)
                    .placeholder(R.drawable.ds)
                    .into(binding.img)

            }
        }
    }

    private fun loadURL(embedUrl: String?) {
        val webView = binding.webView
        ViewUtil.show(webView)

        webView.settings.apply {
            loadWithOverviewMode = true
            useWideViewPort = true
            mediaPlaybackRequiresUserGesture = false
        }

        if (embedUrl != null) {
            webView.loadUrl(embedUrl)
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