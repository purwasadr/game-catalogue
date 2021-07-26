package com.alurwa.gamecatalogue

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alurwa.gamecatalogue.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private val binding: ActivityAboutBinding by lazy {
        ActivityAboutBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupToolbar()
    }

    private fun setupToolbar() {
        supportActionBar?.apply {
            title = getString(R.string.about_toolbar_title)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}