package ru.fefu.activitytracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.fefu.activitytracker.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtonsListeners()

    }

    private fun initButtonsListeners() {
        binding.tbLayout.toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}