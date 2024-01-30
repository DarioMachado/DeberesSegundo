package com.example.llamador

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    private val receiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            //Básicamente se activa cuando sube o baja el volumen
            if (intent?.action == "android.media.VOLUME_CHANGED_ACTION") {

                val streamType = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1)
                if (streamType == AudioManager.STREAM_MUSIC) {
                    val imagen: ImageView = findViewById(R.id.imageView2)
                    //Pone la imagen de la llamada de fondo (por defecto es un fondo transparente)
                    imagen.setImageResource(R.drawable.llamada)
                    //Esto es para forzar a que el audio salga a través de los altavoces, aunque tengas conectado auriculares por bluetooth
                    forceAudioThroughSpeaker()
                    //chipichipichapachapadubidubidabadaba
                    if(mediaPlayer == null || !mediaPlayer!!.isPlaying) {
                        mediaPlayer = MediaPlayer.create(context, R.raw.chipichipi)
                        mediaPlayer?.start()
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar: ActionBar? = supportActionBar
        //Para que sea más realista la imagen de la llamada
        if (actionBar != null) {
            actionBar.hide()
        }
        val filter = IntentFilter("android.media.VOLUME_CHANGED_ACTION")
        registerReceiver(receiver, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

    override fun onPause() {
        //Para que no moleste
        super.onPause()
        mediaPlayer?.stop()
        val vibrator= getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
        vibrator?.cancel()
    }


    private fun forceAudioThroughSpeaker() {
        val audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager

        val vibrator= getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
        //Sinceramente lo de los miniseconds creo que no hace nada
        if (vibrator != null && vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(25000, VibrationEffect.EFFECT_HEAVY_CLICK))
            } else {
                vibrator.vibrate(25000)
            }
        }

        //Esta es la parte que "desactiva" el bluetooth
        audioManager.mode = AudioManager.MODE_IN_COMMUNICATION
        if(audioManager.isBluetoothA2dpOn){
            audioManager.isBluetoothA2dpOn = false
            audioManager.isBluetoothScoOn = false
        }

        audioManager.setSpeakerphoneOn(true)
        Log.d("aa", "${audioManager.isSpeakerphoneOn}")
    }
}