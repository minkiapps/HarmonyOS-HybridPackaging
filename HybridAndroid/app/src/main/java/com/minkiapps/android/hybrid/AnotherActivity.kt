package com.minkiapps.android.hybrid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.minkiapps.android.hybrid.databinding.ActivityAnotherBinding
import timber.log.Timber

class AnotherActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAnotherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)

        binding = ActivityAnotherBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnAnotherActivity
        binding.btnAnotherActivity.setOnClickListener {
            Timber.d("Starting AnotherAbility")
            ConnectionUtil.startAbility(
                this,
                BUNDLE_NAME,
                ANOTHER_ABILITY_NAME
            )
        }
    }
}