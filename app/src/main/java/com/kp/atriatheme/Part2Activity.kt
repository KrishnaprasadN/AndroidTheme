package com.kp.atriatheme

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.kp.atriatheme.databinding.ActivityPart1Binding
import com.kp.atriatheme.databinding.ActivityPart2Binding
import java.io.BufferedReader
import java.io.InputStreamReader

class Part2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityPart2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // this sets the actual app theme
        setTheme(R.style.AppTheme_RED)

        binding = ActivityPart2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.next.setOnClickListener {
            startActivity(Intent(this@Part2Activity, Part2TwoActivity::class.java))
        }

    }

    private fun showToast(text: String) {
        Toast.makeText(this@Part2Activity, text, Toast.LENGTH_SHORT).show()
    }

    private fun readThemeAndApply() {
        val bufferedReader =
            BufferedReader(InputStreamReader(resources.openRawResource(R.raw.localdata)))
        val jsonString = bufferedReader.use {
            it.readText()
        }

        showToast(jsonString)
    }

}