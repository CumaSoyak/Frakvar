package farkvar.com.di

import androidx.room.Room
import farkvar.com.data.local.database.CoreDb
import farkvar.com.utils.AppConstants
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module


val localModule = module {
    single {
        Room.databaseBuilder(androidApplication(), CoreDb::class.java, AppConstants.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<CoreDb>().constantDao() }
}