
package com.example.ballometer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ballometer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAnuar.setOnClickListener {
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("username", "Аниуар")
            startActivity(intent)
        }

        binding.btnTemirkan.setOnClickListener {
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("username", "Темиркан")
            startActivity(intent)
        }
    }
}
