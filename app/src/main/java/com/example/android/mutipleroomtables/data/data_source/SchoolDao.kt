package com.example.android.mutipleroomtables.data.data_source

import androidx.room.*
import com.example.android.mutipleroomtables.data.entities.Director
import com.example.android.mutipleroomtables.data.entities.School
import com.example.android.mutipleroomtables.data.entities.Student
import com.example.android.mutipleroomtables.data.entities.relations.SchoolAndDirector
import com.example.android.mutipleroomtables.data.entities.relations.SchoolWithStudents

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>

}