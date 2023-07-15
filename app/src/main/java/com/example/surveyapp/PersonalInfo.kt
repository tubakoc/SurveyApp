package com.example.surveyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.surveyapp.databinding.ActivityMainBinding
import com.example.surveyapp.databinding.ActivityPersonalInfoBinding
import com.example.surveyapp.model.Person

class PersonalInfo : AppCompatActivity() {
    private lateinit var binding : ActivityPersonalInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            val intentMessage = intent.getStringExtra("nameAndSurname")

            nameSurname.text = intentMessage

            btnSave.setOnClickListener {

                val email = etEmail.text.toString()

                val phone = etPhone.text.toString()

                val age = etAge.text.toString()

                val city = etCity.text.toString()

                val nameAndSurname = intentMessage.toString()


                if (email.isNotEmpty() && phone.isNotEmpty() && age.isNotEmpty() && city.isNotEmpty())
                {
                    val person = Person(nameAndSurname,email,age.toInt(), phone.toInt(),city)
                    val intent = Intent(this@PersonalInfo,CustomInfo::class.java)
                    intent.putExtra("person",person)
                    startActivity(intent)
                }

                else
                {
                    Toast.makeText(this@PersonalInfo,"Please fill in all fields",
                        Toast.LENGTH_LONG).show()

                }
            }
        }

    }
}