package com.example.surveyapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.surveyapp.databinding.ActivityCustomInfoBinding
import com.example.surveyapp.model.Person
import com.example.surveyapp.model.PersonInfo


class CustomInfo : AppCompatActivity() {

    private lateinit var binding:ActivityCustomInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCustomInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            val person = intent.getParcelableExtra("person") as Person?

            nameAndSurname.text = person?.nameSurname

            btnSave.setOnClickListener {

                with(binding)
                {
                    val favoriteColor = etColor.text.toString()
                    val favoriteFood = etFood.text.toString()
                    val favoriteBook = etBook.text.toString()

                    if (favoriteBook.isNotEmpty() && favoriteColor.isNotEmpty() && favoriteFood.isNotEmpty())
                    {
                        val personInfo = PersonInfo(person,favoriteColor,favoriteFood,favoriteBook)

                        val intent = Intent(this@CustomInfo,Results::class.java)
                        intent.putExtra("personInfo",personInfo)
                        startActivity(intent)
                    }

                    else
                    {
                        Toast.makeText(this@CustomInfo,"Please fill in all fields",
                            Toast.LENGTH_LONG).show()
                    }

                }
            }
        }
    }
}
