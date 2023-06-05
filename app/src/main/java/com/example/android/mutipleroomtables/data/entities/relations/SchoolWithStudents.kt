package com.example.android.mutipleroomtables.data.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.android.mutipleroomtables.data.entities.School
import com.example.android.mutipleroomtables.data.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)
