package farkvar.com.data.local

import androidx.annotation.WorkerThread
import farkvar.com.data.local.dao.ConstantDao
import farkvar.com.data.local.model.ConstantEntity


class LocalDataManager(private val constantDao: ConstantDao) : ILocalDataManager {

    override fun insertConstant(constantEntity: ConstantEntity) = constantDao.insert(constantEntity)

    override fun deleteConstant() = constantDao.delete()

    override fun getConstant(): ConstantEntity = constantDao.constants
}