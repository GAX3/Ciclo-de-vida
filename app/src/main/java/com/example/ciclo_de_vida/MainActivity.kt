package com.example.ciclo_de_vida

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ciclo_de_vida.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private var position: Int = 0
    lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        //mediaPlayer?.start()
        Log.i("lifeCycle", "onCreate")

        mBinding.btnSkip.setOnClickListener {
            startActivity(Intent(this, DialogActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("lifeCycle", "onStart")
        mediaPlayer = MediaPlayer.create(this, R.raw.music)
    }

    override fun onResume() {
        super.onResume()
        Log.i("lifeCycle", "onResume")
        mediaPlayer?.seekTo(position)
        mediaPlayer?.start()
    }

    override fun onPause() {
        super.onPause()
        Log.i("lifeCycle", "onPause")
        mediaPlayer?.pause()
        if(mediaPlayer != null)
        position = mediaPlayer!!.currentPosition
    }

    override fun onStop() {
        super.onStop()
        Log.i("lifeCycle", "onStop")
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null

    }

    override fun onRestart() {
        super.onRestart()
        Log.i("lifeCycle", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("lifeCycle", "onDestroy")
    }

}