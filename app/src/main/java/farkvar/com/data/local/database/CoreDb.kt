package farkvar.com.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import farkvar.com.data.local.dao.ConstantDao
import farkvar.com.data.local.model.ConstantEntity

@Database(
    entities = [ConstantEntity::class],
    version = 4,
    exportSchema = false
)
abstract class CoreDb : RoomDatabase() {
    abstract fun constantDao(): ConstantDao
}