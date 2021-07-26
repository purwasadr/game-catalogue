package com.alurwa.gamecatalogue

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.alurwa.gamecatalogue.adapter.GameAdapter
import com.alurwa.gamecatalogue.databinding.ActivityMainBinding
import com.alurwa.gamecatalogue.model.Game

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapter: GameAdapter by lazy {
        GameAdapter {
            navigateToDetail(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        setupToolbar()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        with(binding) {
            listGame.setHasFixedSize(true)
            listGame.addItemDecoration(DividerItemDecoration(
                    applicationContext,
                    DividerItemDecoration.VERTICAL
                )
            )
            listGame.adapter = adapter
        }
    }

    private fun setupToolbar() {
        supportActionBar?.apply {
            title = getString(R.string.main_toolbar_title)
        }
    }

    private fun navigateToDetail(game: Game) {
        Intent(this, DetailActivity::class.java)
            .putExtra(DetailActivity.EXTRA_GAME, game)
            .also {
                startActivity(it)
            }
    }

    private fun navigateToAbout() {
        Intent(this, AboutActivity::class.java)
            .also {
                startActivity(it)
            }
    }

    private fun navigateToSetting() {
        Intent(this, SettingsActivity::class.java)
            .also {
                startActivity(it)
            }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about -> {
                navigateToAbout()
                true
            }

            R.id.setting -> navigateToSetting().let { true }

            else -> super.onOptionsItemSelected(item)
        }
    }
}