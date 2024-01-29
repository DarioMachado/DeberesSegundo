package com.example.retoinflater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.nex3z.flowlayout.FlowLayout

class RetoMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rootView = LayoutInflater.from(this).inflate(R.layout.activity_reto_main, null)
        val flowLayout = rootView.findViewById<FlowLayout>(R.id.layout)
        setContentView(rootView)

        val handler = Handler(Looper.getMainLooper())

        var imagenes = arrayOf(R.drawable.frame_0_delay_0_2s, R.drawable.frame_1_delay_0_2s, R.drawable.frame_2_delay_0_2s, R.drawable.frame_3_delay_0_2s)
        imagenes = imagenes + imagenes //SOY UN PSICÓPATA

        for (i in imagenes.indices) {
            handler.postDelayed({
                var imageView = ImageView(this)
                imageView.setImageResource(imagenes[i])


                flowLayout.addView(imageView)
                imageView.layoutParams.height = 200
            }, (i + 1) * 1000L)
        }

    }
}