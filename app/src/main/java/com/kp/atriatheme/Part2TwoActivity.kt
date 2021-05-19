package com.kp.atriatheme

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.kp.atriatheme.databinding.ActivityPart1Binding
import com.kp.atriatheme.databinding.ActivityPart22Binding
import com.kp.atriatheme.databinding.ActivityPart2Binding
import java.io.BufferedReader
import java.io.InputStreamReader

class Part2TwoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPart22Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme_CYAN)

        binding = ActivityPart22Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}