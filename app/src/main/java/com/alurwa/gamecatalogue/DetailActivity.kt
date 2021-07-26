package com.alurwa.gamecatalogue

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alurwa.gamecatalogue.databinding.ActivityDetailBinding
import com.alurwa.gamecatalogue.model.Game

class DetailActivity : AppCompatActivity() {
    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    private val game: Game by lazy {
        intent.getParcelableExtra(EXTRA_GAME)!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupToolbar()

        setupView()
    }

    private fun setupView() {
        binding.game = game
    }

    private fun setupToolbar() {
        supportActionBar?.apply {
            title = "Detail"
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_GAME = "extra_game"
    }
}