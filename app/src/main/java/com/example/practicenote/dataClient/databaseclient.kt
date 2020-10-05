package com.example.practicenote.dataClient

import android.content.Context
import androidx.room.Room

class databaseclient() {


    // this DATABASEBUILDER CLASS-> databaseclient class

    companion object {

        //mutable value for generating instance
        @Volatile
        private var nInstance: AppDatabase? = null

        fun getInstance(c: Context): AppDatabase {

            if (nInstance == null) {

                synchronized(AppDatabase::class) {

                    nInstance = createRoomDB(c)

                }

            }
            // non-null asserted(!!) call
            return nInstance!!

        }

        private fun createRoomDB(c: Context) =
            Room.databaseBuilder(c.applicationContext, AppDatabase::class.java, "note").fallbackToDestructiveMigration().build()


    }


}
//using this when clearing room database during production .fallbackToDestructiveMigration() method
