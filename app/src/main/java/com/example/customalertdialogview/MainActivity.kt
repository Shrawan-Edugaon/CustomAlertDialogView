package com.example.customalertdialogview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun showAlert(v:View)
    {
        val inflater = layoutInflater
        val inflater_view = inflater.inflate(R.layout.custom_alert_dialog,null)
        val userNameEdt = inflater_view.findViewById(R.id.userName) as EditText
        val userPasswordEdt =inflater_view.findViewById(R.id.password) as EditText

        val checkBoxToggle = inflater_view.findViewById(R.id.showPassCheck) as CheckBox

        checkBoxToggle.setOnCheckedChangeListener { buttonView, isCheck ->
            if (isCheck)
            {
                userPasswordEdt.transformationMethod = PasswordTransformationMethod.getInstance()
            }
            else
            {
                userPasswordEdt.transformationMethod =null
            }
        }
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Enter Details.")
        alertDialog.setView(inflater_view) //this set custom xml in alertdialog
        alertDialog.setCancelable(false)

        alertDialog.setNegativeButton("Cancel"){dialog,which->
            Toast.makeText(this,"Cancel Button",Toast.LENGTH_LONG).show()
        }
        alertDialog.setPositiveButton("Done"){dialog,which->
            val userName = userNameEdt.text.toString()
            val userPass = userPasswordEdt.text.toString()
            Toast.makeText(this,"UserName:$userName Password:$userPass",Toast.LENGTH_LONG).show()
        }
        val dialog = alertDialog.create()
        dialog.show()
        }

    }
