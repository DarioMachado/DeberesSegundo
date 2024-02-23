package com.example.aplicacionsimulacro

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Video
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.VideoView
import androidx.core.view.updateLayoutParams

class FreePussyVideo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rootView = LayoutInflater.from(this).inflate(R.layout.activity_free_pussy_video, null)

        val linearLayout = rootView.findViewById<LinearLayout>(R.id.milayout)
        setContentView(rootView)

        val relativeLayout1 :RelativeLayout = RelativeLayout(this)
        val video1: VideoView = VideoView(this)
        val video1Path = "android.resource://${packageName}/${R.raw.gatito1}"
        val video1Uri = Uri.parse(video1Path)
        video1.setVideoURI(video1Uri)
        relativeLayout1.addView(video1)
        linearLayout.addView(relativeLayout1)

        val mediaController = android.widget.MediaController(this)
        video1.setMediaController(mediaController)
        mediaController.setAnchorView(video1)
        video1.start()


        val relativeLayout2 :RelativeLayout = RelativeLayout(this)
        val video2: VideoView = VideoView(this)
        val video2Path = "android.resource://${packageName}/${R.raw.gatito2}"
        val video2Uri = Uri.parse(video2Path)
        video2.setVideoURI(video2Uri)
        relativeLayout2.addView(video2)
        linearLayout.addView(relativeLayout2)

        val mediaController2 = android.widget.MediaController(this)
        video2.setMediaController(mediaController2)
        mediaController2.setAnchorView(video2)
        video2.start()


        val relativeLayout3 :RelativeLayout = RelativeLayout(this)
        val video3: VideoView = VideoView(this)
        val video3Path = "android.resource://${packageName}/${R.raw.gatito3}"
        val video3Uri = Uri.parse(video3Path)
        video3.setVideoURI(video3Uri)
        relativeLayout3.addView(video3)
        linearLayout.addView(relativeLayout3)

        val mediaController3 = android.widget.MediaController(this)
        video3.setMediaController(mediaController3)
        mediaController3.setAnchorView(video3)
        video3.start()


    }
}