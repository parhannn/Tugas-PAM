package com.example.app.ui.helper

import androidx.fragment.app.Fragment
import com.example.app.ui.skill.Skill
import com.example.app.R

object ConstraintUtil {

    fun getSkillData(fragement: Fragment): ArrayList<Skill> {
        val skillArrayList = ArrayList<Skill>()
        val skills = fragement.resources.getStringArray(R.array.string_skill_array)
        val images = fragement.resources.getIntArray(R.array.integer_skill_array)
        for (i in 0 .. skills.size) {
            skillArrayList.add(Skill(images[i], skills[i]))
        }

        return skillArrayList
    }

}