package br.com.ericserafim.kjogovelha

import android.content.Context
import android.media.MediaPlayer

open class SoundEffects {

    companion object {
        fun playNoWins(context: Context) {
            val mp : MediaPlayer = MediaPlayer.create(context, R.raw.nowins)
            mp.start()
        }

        fun playWins(context: Context) {
            val mp : MediaPlayer = MediaPlayer.create(context, R.raw.wins)
            mp.start()
        }

        fun playNewGame(context: Context) {
            val mp : MediaPlayer = MediaPlayer.create(context, R.raw.newgame)
            mp.start()
        }
    }

}