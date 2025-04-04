
package com.example.ballometer

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ballometer.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBinding
    private lateinit var username: String
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        username = intent.getStringExtra("username") ?: "Неизвестный"
        title = "Баллы: $username"

        val prefs = getSharedPreferences("scores", MODE_PRIVATE)
        score = prefs.getInt(username, 0)
        updateScoreText()

        binding.btnAdd.setOnClickListener {
            score += 5
            updateScoreText()
            saveScore()
        }

        binding.btnPenalty.setOnClickListener {
            score -= 3
            updateScoreText()
            saveScore()
        }

        binding.btnBonus.setOnClickListener {
            if (score >= 10) {
                score -= 10
                updateScoreText()
                saveScore()
                Toast.makeText(this, "Бонус применён!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Недостаточно баллов для бонуса", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnReport.setOnClickListener {
            Toast.makeText(this, "Баллы $username: $score", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateScoreText() {
        binding.tvScore.text = "Баллы: $score"
    }

    private fun saveScore() {
        val prefs = getSharedPreferences("scores", MODE_PRIVATE)
        prefs.edit().putInt(username, score).apply()
    }
}
