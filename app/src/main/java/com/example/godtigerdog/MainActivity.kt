package com.example.godtigerdog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val godButton = findViewById<RadioButton>(R.id.godButton);
        val tigerButton = findViewById<RadioButton>(R.id.tigerButton);
        val dogButton = findViewById<RadioButton>(R.id.dogButton);
        val startButton = findViewById<Button>(R.id.startButton);
        val inputPlayerNameTipTextView = findViewById<TextView>(R.id.inputPlayerNameTipTextView);
        val inputNameEditText = findViewById<EditText>(R.id.inputNameEditText);
        val playerNameTextView = findViewById<TextView>(R.id.playerNameTextView);
        val victoryTextView = findViewById<TextView>(R.id.victoryTextView);
        val playerMoraTextView = findViewById<TextView>(R.id.playerMoraTextView);
        val computerMoraTextView = findViewById<TextView>(R.id.computerMoraTextView);

        startButton.setOnClickListener {
            if(inputNameEditText.length() < 1) {
                inputPlayerNameTipTextView.text = "請輸入玩家姓名";
                return@setOnClickListener;
            }
            val playerName = inputNameEditText.text;
            val randomMoraNumber = (Math.random() * 3).toInt();
            val playerMoraText = when {
                godButton.isChecked -> "神";
                tigerButton.isChecked -> "老虎";
                else -> "狗";
            }
            val computerMoraText = when(randomMoraNumber) {
                0 -> "神";
                1 -> "老虎";
                else -> "狗";
            }
            playerNameTextView.text = "名字\n$playerName";
            playerMoraTextView.text = "我方出拳\n$playerMoraText";
            computerMoraTextView.text = "電腦出拳\n$computerMoraText";
            when {
                godButton.isChecked && randomMoraNumber == 1 ||
                        tigerButton.isChecked && randomMoraNumber == 2 ||
                        dogButton.isChecked && randomMoraNumber == 0 -> {
                    victoryTextView.text = "勝利者\n$playerName"
                    inputPlayerNameTipTextView.text = "恭喜你獲勝了！！！"
                }
                godButton.isChecked && randomMoraNumber == 2 ||
                        tigerButton.isChecked && randomMoraNumber == 0 ||
                        dogButton.isChecked && randomMoraNumber == 1 -> {
                    victoryTextView.text = "勝利者\n 電腦"
                    inputPlayerNameTipTextView.text = "可惜，電腦獲勝了！"
                }
                else -> {
                    victoryTextView.text = "勝利者\n 平手"
                    inputPlayerNameTipTextView.text = "平局，請再試一次！"
                }
            }
        }
    }


}