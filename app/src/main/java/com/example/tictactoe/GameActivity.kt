package com.example.tictactoe

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import kotlinx.android.synthetic.main.winner_dialouge.*

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }
    fun btnClick(view: View) {
        var cellId = 0
        val btnSelected = view as Button

        when(btnSelected.id){
            R.id.btn1->
                cellId = 1
            R.id.btn2->
                cellId = 2
            R.id.btn3->
                cellId = 3
            R.id.btn4->
                cellId = 4
            R.id.btn5->
                cellId = 5
            R.id.btn6->
                cellId = 6
            R.id.btn7->
                cellId = 7
            R.id.btn8->
                cellId = 8
            R.id.btn9->
                cellId = 9
        }
        btnClicked(cellId, btnSelected)
    }

    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    fun btnClicked(cellId: Int, btnSelected: Button){

        if(activePlayer == 1){
            btnSelected.text = "0"
            btnSelected.setBackgroundResource(R.drawable.player_one_btn_shape)
            player1.add(cellId)
            activePlayer = 2
        } else {
            btnSelected.text = "x"
            btnSelected.setBackgroundResource(R.drawable.player_two_btn_shape)
            player2.add(cellId)
            activePlayer = 1
        }
        btnSelected.isEnabled = false
        checkWinner()
    }

    fun checkWinner(){
        var winner = -1

        if((player1.contains(1) && player1.contains(2) && player1.contains(3))
            || (player1.contains(4) && player1.contains(5) && player1.contains(6))
            || (player1.contains(7) && player1.contains(8) && player1.contains(9))
            || (player1.contains(1) && player1.contains(4) && player1.contains(7))
            || (player1.contains(2) && player1.contains(5) && player1.contains(8))
            || (player1.contains(3) && player1.contains(6) && player1.contains(9))
            || (player1.contains(1) && player1.contains(5) && player1.contains(9))
            || (player1.contains(3) && player1.contains(5) && player1.contains(7)))
        {
            winner = 1
        }
        else if((player2.contains(1) && player2.contains(2) && player2.contains(3))
            || (player2.contains(4) && player2.contains(5) && player2.contains(6))
            || (player2.contains(7) && player2.contains(8) && player2.contains(9))
            || (player2.contains(1) && player2.contains(4) && player2.contains(7))
            || (player2.contains(2) && player2.contains(5) && player2.contains(8))
            || (player2.contains(3) && player2.contains(6) && player2.contains(9))
            || (player2.contains(1) && player2.contains(5) && player2.contains(9))
            || (player2.contains(3) && player2.contains(5) && player2.contains(7)))
        {
            winner = 2
        }

        if(winner == 1) {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.winner_dialouge)
            dialog.txt_winner.text = "Player 1 win the game!"
            dialog.btn_exit.setOnClickListener {
                val intent = Intent(this, StartScreenActivity::class.java)
                startActivity(intent)
            }
            dialog.btn_play_again.setOnClickListener {
                val intent = Intent(this, GameActivity::class.java)
                finish()
                startActivity(intent)
            }
            dialog.show()
        }
        else if (winner == 2){
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.winner_dialouge)
            dialog.txt_winner.text = "Player 2 win the game!"
            dialog.btn_exit.setOnClickListener {
                val intent = Intent(this, StartScreenActivity::class.java)
                startActivity(intent)
            }
            dialog.btn_play_again.setOnClickListener {
                val intent = Intent(this, GameActivity::class.java)
                finish()
                startActivity(intent)
            }
            dialog.show()
        }
    }
}