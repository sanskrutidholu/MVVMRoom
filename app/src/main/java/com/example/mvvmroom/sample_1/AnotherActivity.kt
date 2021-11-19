package com.example.mvvmroom.sample_1

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmroom.R
import kotlinx.android.synthetic.main.s1_activity_another.*
import java.util.*
import kotlin.properties.Delegates

class AnotherActivity : AppCompatActivity() {
    //@SuppressLint("RestrictedApi")
    private lateinit var  getData:String
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var date:Date
    private var getCharacter by Delegates.notNull<Long>()
    private lateinit var getDate:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.s1_activity_another)

        setSupportActionBar(toolbar1)
        noteViewModel= NoteViewModel()
        val upArrow=resources.getDrawable(R.drawable.arrow)

        getDate()
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
            setHomeAsUpIndicator(upArrow)
        }
        toolbar1.setNavigationOnClickListener {
            backToHomePage()
        }
        note.addTextChangedListener(textWatcher)
    }

    private val textWatcher= object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            characters.text= " | Characters "+s?.length.toString()

        }

    }

    private fun backToHomePage()
    {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun getDate() {
        date=Calendar.getInstance().time
        currentDate.text=date.toString()
    }

    private fun saveDataIntoDatabase() {
        getData=note.text.toString()
        getDate =currentDate.text.toString()
        getCharacter= getData.trim().length.toLong()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater=menuInflater
        inflater.inflate(R.menu.another_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.save -> {
                saveDataIntoDatabase()
                if(getData.isNotEmpty())
                {
                    noteViewModel.insert(applicationContext, Note(getData,getDate,getCharacter))
                    backToHomePage()
                }
                else{
                    Toast.makeText(applicationContext,"type any character",Toast.LENGTH_SHORT).show()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }



}