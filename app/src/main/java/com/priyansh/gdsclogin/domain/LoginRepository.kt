package com.priyansh.gdsclogin.domain

import com.priyansh.gdsclogin.data.Student
import com.priyansh.gdsclogin.data.listOfStudents

class LoginRepository  {

   fun register(student: Student) {
        listOfStudents.add(student)
    }

   fun validateStudent(student: Student) :Boolean{
       return listOfStudents.contains(student)
    }
}