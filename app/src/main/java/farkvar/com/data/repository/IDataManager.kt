package farkvar.com.data.repository

import farkvar.com.data.local.ILocalDataManager
import farkvar.com.data.remote.IRemoteDataManager

interface IDataManager:IRemoteDataManager,ILocalDataManager {
}