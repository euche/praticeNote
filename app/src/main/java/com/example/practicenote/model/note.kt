package com.example.practicenote.model

import android.content.Context
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*


@Entity
data class note(
    @PrimaryKey(autoGenerate = true) val nid: Int,
    @ColumnInfo(name = "n_title") val title: String,
    @ColumnInfo(name = "n_content") val ncontent: String
) {


//    fun getNdateandtime( c: Context):String {
//
//        val df = SimpleDateFormat("dd/MM/yyyy HH:mm", c.resources.configuration.locale)
//        df.setTimeZone(TimeZone.getDefault())
//        return df.format(Date(dtime))
//
//    }

}