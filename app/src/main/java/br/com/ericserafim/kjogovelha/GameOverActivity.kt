package br.com.ericserafim.kjogovelha

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_game_over.*


class GameOverActivity : AppCompatActivity() {

    var isWinner: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        tv_player.text = ""
        isWinner = intent.extras.getBoolean("isWinner")

        if (isWinner) {
            tv_player.text = "O " + intent.extras?.getString("winner") + ", venceu esta partida."
        } else {
            tv_title.text = "Que pena!!"
            tv_player.text = "Ninguém venceu desta vez!!!"
            img_icon.setImageDrawable(getDrawable(R.drawable.silent))
        }

        window.enterTransition = ExplodeTransition.builderModeIn()
        window.exitTransition = ExplodeTransition.builderModeOut()
    }

    override fun onResume() {
        super.onResume()

        if (isWinner) {
            SoundEffects.playWins(this)
        } else {
            SoundEffects.playNoWins(this)
        }
    }

    fun restart(view: View) {
        SoundEffects.playNewGame(this)
        val it = Intent(this, MainActivity::class.java)

        finishAfterTransition()
        startActivity(it,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())

    }


}
