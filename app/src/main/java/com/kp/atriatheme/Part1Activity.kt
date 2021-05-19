package com.kp.atriatheme

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.kp.atriatheme.databinding.ActivityPart1Binding
import java.io.BufferedReader
import java.io.InputStreamReader

class Part1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityPart1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPart1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        loadUrlImage("https://homepages.cae.wisc.edu/~ece533/images/airplane.png")

        binding.changeTheme.setOnClickListener {
            readThemeAndApply()
        }
        //readThemeAndApply()
    }

    private fun showToast(text: String) {
        Toast.makeText(this@Part1Activity, text, Toast.LENGTH_SHORT).show()
    }

    private fun readThemeAndApply() {
        val bufferedReader =
            BufferedReader(InputStreamReader(resources.openRawResource(R.raw.localdata)))
        val jsonString = bufferedReader.use {
            it.readText()
        }

        showToast(jsonString)
        setColor(Gson().fromJson(jsonString, Config::class.java))
    }

    private fun setColor(config: Config) {
        // 1) change text color
        binding.content.setTextColor(Color.parseColor(config.textColor))

        // 2) change text background color
        binding.content.setBackgroundColor(Color.parseColor(config.buttonTextColor))

        // 3) change input text color
        binding.input.setTextColor(Color.parseColor(config.inputTextColor))

        // 4) change screen background color
        binding.root.setBackgroundColor(Color.parseColor(config.bgColor))

        // 5) change button background color
        binding.changeTheme.setBackgroundColor(Color.parseColor(config.textColor))

        // 6) change button text color
        binding.changeTheme.setTextColor(Color.parseColor(config.buttonTextColor))

        // 7) change image based on url
        loadUrlImage(config.imgUrl)
    }

    private fun loadUrlImage(url: String) {
        Glide.with(this).load(url).into(binding.img);
    }
}