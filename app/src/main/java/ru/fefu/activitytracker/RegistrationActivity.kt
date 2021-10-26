package ru.fefu.activitytracker

import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.appcompat.app.AppCompatActivity
import ru.fefu.activitytracker.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtonsListeners()

        binding.tvPolicy.movementMethod = LinkMovementMethod.getInstance()

    }

    private fun initButtonsListeners() {
        binding.tbLayout.toolbar.setNavigationOnClickListener {
            finish()
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}