package ar.edu.unlam.mobile.scaffolding.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [AndroidEntity::class],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun androidDao(): AndroidDao
}
