package com.example.app.ui.skill

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.app.R

class SkillDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_skill_detail)

        val skill = intent.getParcelableExtra<Skill>("skill")
        if(skill != null){
            val textView: TextView = findViewById(R.id.skill_detail)
            val imageView: ImageView = findViewById(R.id.skill_image)

            textView.text= skill.heading
            imageView.setImageResource(skill.titleImage)
        }
    }
}