package br.com.ericserafim.kjogovelha

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    val resultsWinners = listOf(
            listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9), //Linhas
            listOf(1, 4, 7), listOf(2, 5, 8), listOf(3, 6, 9), //Colunas
            listOf(1, 5, 9), listOf(3, 5, 7) //Diagonais
    )
    val playerOne = ArrayList<Int>()
    val playerTwo = ArrayList<Int>()
    var currentPlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.enterTransition = ExplodeTransition.builderModeIn()
        window.exitTransition = ExplodeTransition.builderModeOut()
    }

    fun play(position: Int, currentBtn: Button) {

        if (currentPlayer == 1) {
            currentBtn.text = "X"
            currentBtn.setBackgroundResource(R.color.colorPlayer1)
            playerOne.add(position)
            currentPlayer = 2
        } else {
            currentBtn.text = "O"
            currentBtn.setBackgroundResource(R.color.colorPlayer2)
            playerTwo.add(position)
            currentPlayer = 1
        }

        currentBtn.isClickable = false

        checkWinner()
    }

    fun btnPosition(view: View) = play(view.tag.toString().toInt(), view as Button)

    fun checkWinner() {

        if (isWinner(playerOne)) {
            gameOver("Jogador 1 (X)", true)
            return
        }

        if (isWinner(playerTwo)) {
            gameOver("Jogador 2 (O)", true)
            return
        }

        if (playerOne.size + playerTwo.size == 9) {
            gameOver("Não houve vencedor!", false)
            return
        }

    }

    fun isWinner(playerList: ArrayList<Int>): Boolean {
        resultsWinners.forEach {
            if (playerList.containsAll(it)) return true
        }

        return false
    }

    fun gameOver(winner: String, isWinner : Boolean) {
        val it = Intent(this, GameOverActivity::class.java)
        it.putExtra("winner", winner)
        it.putExtra("isWinner", isWinner)

        finishAfterTransition()
        startActivity(it,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }
}
