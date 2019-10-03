package farkvar.com.data.local

import farkvar.com.data.local.model.ConstantEntity


interface ILocalDataManager {
    fun insertConstant(constantEntity: ConstantEntity)
    fun deleteConstant()
    fun getConstant(): ConstantEntity
}