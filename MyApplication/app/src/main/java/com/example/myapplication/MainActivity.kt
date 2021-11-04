package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edName = findViewById<EditText>(R.id.ed_name);
        val tvText = findViewById<TextView>(R.id.tv_text);
        val btnScissor = findViewById<RadioButton>(R.id.btn_scissor);
        val btnStone = findViewById<RadioButton>(R.id.btn_stone);
        val btnPaper = findViewById<RadioButton>(R.id.btn_paper);
        val btnMora = findViewById<Button>(R.id.btn_Start);
        val tvName = findViewById<TextView>(R.id.tv_Name);
        val tvWinner = findViewById<TextView>(R.id.tv_winner);
        val tvMmora = findViewById<TextView>(R.id.tv_mmora);
        val tvCmora = findViewById<TextView>(R.id.tv_cmora);

        btnMora.setOnClickListener {
            //判斷 EditText 的字數是否小於一，若成立則無法進行猜拳
            if (edName.length() < 1) {
                tvText.text = "請輸入玩家姓名"
                return@setOnClickListener
            }
            //取出 EditText 文字作為玩家姓名並用變數儲存
            val playerName = edName.text
            //亂數產生介於 0~1 之間不含 1 的小數，乘 3 變成 0~2 作為電腦的出拳
            val comMora = (Math.random() * 3).toInt()
            //將玩家出拳結果對應成字串並用變數儲存
            val playerMoraText = when {
                btnScissor.isChecked -> "剪刀"
                btnStone.isChecked -> "石頭"
                else -> "布"
            }
            //將電腦出拳結果對應成字串並用變數儲存
            val comMoraText = when (comMora) {
                0 -> "剪刀"
                1 -> "石頭"
                else -> "布"
            }
            //顯示玩家姓名與雙方出拳結果
            tvName.text = "名字\n$playerName"
            tvMmora.text = "我方出拳\n$playerMoraText"
            tvCmora.text = "電腦出拳\n$comMoraText"
            //用三個判斷式決定勝負並顯示猜拳結果
            when {
                btnScissor.isChecked && comMora == 2 ||
                        btnStone.isChecked && comMora == 0 ||
                        btnPaper.isChecked && comMora == 1 -> {
                    tvWinner.text = "勝利者\n$playerName"
                    tvText.text = "恭喜你獲勝了！！！"
                }
                btnScissor.isChecked && comMora == 1 ||
                        btnStone.isChecked && comMora == 2 ||
                        btnPaper.isChecked && comMora == 0 -> {
                    tvWinner.text = "勝利者\n 電腦"
                    tvText.text = "可惜，電腦獲勝了！"
                }
                else -> {
                    tvWinner.text = "勝利者\n 平手"
                    tvText.text = "平局，請再試一次！"
                }
            }
        }
    }
}