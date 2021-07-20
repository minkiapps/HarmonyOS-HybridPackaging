package com.minkiapps.android.hybrid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.minkiapps.android.hybrid.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : Activity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnMainActivityGotoAbility.setOnClickListener {
            Timber.d("Starting MainAbility")
            ConnectionUtil.startAbility(
                this@MainActivity,
                BUNDLE_NAME,
                MAIN_ABILITY_NAME
            )
        }

        binding.btnMainActivityGotoAnotherActivity.setOnClickListener {
            startActivity(Intent(this, AnotherActivity::class.java))
        }

        intent.getStringExtra("EXTRA_SOURCE")?.let {
            binding.tvActivityMainSource.text = it
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        Toast.makeText(this, "On new Intent", Toast.LENGTH_SHORT).show()
        intent.getStringExtra("EXTRA_SOURCE")?.let {
            binding.tvActivityMainSource.text = it
        }
    }
}