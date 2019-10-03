package farkvar.com.di

import farkvar.com.data.remote.service.ServiceClient.createWebService
import farkvar.com.data.remote.service.buslist.IBusService
import org.koin.dsl.module.module

val remoteModule = module {
    factory { createWebService<IBusService>() }

}