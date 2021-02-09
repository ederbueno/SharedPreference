package br.com.edma.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initProfile(configSharedPreferences())
        click()

    }

    private fun initProfile(prefs : SharedPreferences){
        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvRegistration = findViewById<TextView>(R.id.tv_registration)

        val showName = prefs.getBoolean(MainActivity.SHOW_NAME, true)
        val showRegistration = prefs.getBoolean(MainActivity.SHOW_REGISTRATION, true)

        tvName.text = "Ederson"
        tvRegistration.text = "2321949"

        tvName.visibility = if(showName) View.VISIBLE else View.GONE
        tvRegistration.visibility = if(showRegistration) View.VISIBLE else View.GONE
    }

    private fun configSharedPreferences() = getSharedPreferences(MainActivity.USER_PREFS, Context.MODE_PRIVATE)

    fun click() {
       findViewById<Button>(R.id.back_button)
           .setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }


}