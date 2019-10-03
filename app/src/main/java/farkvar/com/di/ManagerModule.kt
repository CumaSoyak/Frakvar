package farkvar.com.di

import farkvar.com.data.local.LocalDataManager
import farkvar.com.data.remote.RemoteDataManager
import farkvar.com.data.repository.DataManager
import org.koin.dsl.module.module


val managerModule = module {
    single { LocalDataManager(get()) }
    single { RemoteDataManager(get()) }
    single { DataManager(get(), get()) }
}