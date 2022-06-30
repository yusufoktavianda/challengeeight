package binar.academy.challengeeight.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Photo::class], version = 1)
abstract class ApplicationDB : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
}