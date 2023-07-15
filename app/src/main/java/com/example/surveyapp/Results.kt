package com.example.surveyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.surveyapp.databinding.ActivityPersonalInfoBinding
import com.example.surveyapp.databinding.ActivityResultsBinding
import com.example.surveyapp.model.PersonInfo

class Results : AppCompatActivity() {

    private lateinit var binding:ActivityResultsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {

            val personInfoResult = intent.getParcelableExtra("personInfo") as PersonInfo?

            etNameSurname.text = personInfoResult?.person?.nameSurname

            etEmail.text = personInfoResult?.person?.email
            etCity.text = personInfoResult?.person?.city
            etPhone.text = personInfoResult?.person?.phone.toString()
            etAge.text = personInfoResult?.person?.age.toString()
            etColor.text = personInfoResult?.fColor
            etFood.text = personInfoResult?.fFood
            etBook.text = personInfoResult?.fBook

            btnHomePage.setOnClickListener {
                HomePage()
            }
        }

    }

    private var onBackPressCount = 0

    override fun onBackPressed() {

        onBackPressCount++

        if (onBackPressCount == 1)
        {
            Toast.makeText(this,"Press again to return to the Main Page.",
                Toast.LENGTH_LONG).show()
        }

        else if (onBackPressCount == 2 || onBackPressCount>2)
        {
            super.onBackPressed()
            HomePage()
        }
    }

    fun HomePage()
    {
        val intent = Intent(this@Results,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }


}